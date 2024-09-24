package org.solidgate.payment;

import com.codeborne.selenide.Selenide;
import org.solidgate.api.facade.OrderFacade;
import org.solidgate.api.facade.PaymentFacade;
import org.solidgate.api.model.CreditCard;
import org.solidgate.api.model.Order;
import org.solidgate.api.model.Payment;
import org.solidgate.api.model.response.OrderStatusResponse;
import org.solidgate.ui.object.business.PaymentBO;
import org.solidgate.ui.object.page.PaymentPage;
import org.solidgate.ui.object.page.SuccessPaymentPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.String.format;
import static org.solidgate.util.DataProvider.getDefaultCreditCardModel;
import static org.solidgate.util.DataProvider.getDefaultPaymentModel;
import static org.solidgate.util.ValidatorManager.verifyFieldValue;
import static org.solidgate.util.constansts.CommonConstants.*;
import static org.solidgate.util.constansts.ValidationConstants.WEB_PAGE_URL_MISMATCH_ERROR_MESSAGE;
import static org.testng.Assert.assertEquals;

public class CreatePaymentTest {

    private Payment payment;
    private PaymentBO paymentBO;

    @BeforeMethod(alwaysRun = true)
    public void setUpPaymentPage() {
        payment = getDefaultPaymentModel();
        String pageUrl = new PaymentFacade().createPaymentPageUrl(payment);
        PaymentPage paymentPage = Selenide.open(pageUrl, PaymentPage.class);
        paymentBO = new PaymentBO(paymentPage);
    }

    @Test(description = "Solidgate: AT-API-UI: Verify that after making a payment, the user is redirected to the 'Success' page")
    public void verifySuccessPaymentFlow() {
        CreditCard creditCard = getDefaultCreditCardModel();

        SuccessPaymentPage successPaymentPage = paymentBO.performOrderPayment(creditCard)
                .verifySuccessPaymentMessagePresence();

        String expectedSuccessUrl = payment.getOrder().getSuccessUrl();
        String actualSuccessUrl = successPaymentPage.getCurrentWebPageUrl();
        String errorMessage = format(WEB_PAGE_URL_MISMATCH_ERROR_MESSAGE, expectedSuccessUrl, actualSuccessUrl);
        assertEquals(actualSuccessUrl, expectedSuccessUrl, errorMessage);
    }

    @Test(description = "Solidgate: AT-API: Verify that after making a payment, the order status is updated to 'success'")
    public void verifyOrderStatusOfSuccessPayment() {
        CreditCard creditCard = getDefaultCreditCardModel();
        OrderFacade orderFacade = new OrderFacade();
        paymentBO.performOrderPayment(creditCard)
                .verifySuccessPaymentMessagePresence();

        Order expectedOrder = payment.getOrder();
        OrderStatusResponse actualOrderStatus = orderFacade.getOrderStatus(expectedOrder.getOrderId());
        Order actualOrder = actualOrderStatus.getOrder();

        SoftAssert softAssert = new SoftAssert();
        verifyFieldValue(ORDER_AMOUNT_FIELD, actualOrder.getAmount(), expectedOrder.getAmount(), softAssert);
        verifyFieldValue(ORDER_CURRENCY_FIELD, actualOrder.getCurrency(), expectedOrder.getCurrency(), softAssert);
        verifyFieldValue(TRANSACTION_STATUS_FIELD, actualOrderStatus.getTransActionStatus(), SUCCESS_STRING, softAssert);
        softAssert.assertAll();
    }
}

package org.solidgate.ui.object.business;


import org.solidgate.api.model.CreditCard;
import org.solidgate.ui.object.page.PaymentPage;
import org.solidgate.ui.object.page.SuccessPaymentPage;

public class PaymentBO {

    private final PaymentPage paymentPage;

    public PaymentBO(PaymentPage paymentPage) {
        this.paymentPage = paymentPage;
    }

    public SuccessPaymentPage performOrderPayment(CreditCard creditCard) {
        paymentPage
                .fillCardNumberInput(creditCard.getCardNumber())
                .fillCardExpiryDateInput(creditCard.getExpirationDate())
                .fillCardCvvInput(creditCard.getCvv())
                .fillCardHolderInput(creditCard.getCardHolder())
                .clickOnPayButton();
        return new SuccessPaymentPage();
    }
}

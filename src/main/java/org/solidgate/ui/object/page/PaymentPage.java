package org.solidgate.ui.object.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.solidgate.util.constansts.CommonConstants.*;

public class PaymentPage extends GeneralPage {

    private final SelenideElement cardNumberInput = $("[data-testid='cardNumber']");
    private final SelenideElement cardExpiryDateInput = $("[data-testid='cardExpiryDate']");
    private final SelenideElement cardCvvInput = $("[data-testid='cardCvv']");
    private final SelenideElement cardHolderInput = $("[data-testid='cardHolder']");
    private final SelenideElement payButton = $("[data-testid='submit']");

    public PaymentPage fillCardNumberInput(String cardNumber) {
        fillVisibleInputField(cardNumberInput, cardNumber, CARD_NUMBER_FIELD);
        return this;
    }

    public PaymentPage fillCardExpiryDateInput(String cardExpiration) {
        fillVisibleInputField(cardExpiryDateInput, cardExpiration, CARD_EXPIRY_DATE_FIELD);
        return this;
    }

    public PaymentPage fillCardCvvInput(String cardCvv) {
        fillVisibleInputField(cardCvvInput, cardCvv, CARD_CVV_FIELD);
        return this;
    }

    public PaymentPage fillCardHolderInput(String cardHolder) {
        fillVisibleInputField(cardHolderInput, cardHolder, CARD_HOLDER_FIELD);
        return this;
    }

    public void clickOnPayButton() {
        clickOnVisibleElement(payButton, PAY_BUTTON_FIELD);
    }
}

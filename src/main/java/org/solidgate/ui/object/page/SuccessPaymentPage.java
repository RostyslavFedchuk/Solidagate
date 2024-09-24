package org.solidgate.ui.object.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SuccessPaymentPage extends GeneralPage {

    private final SelenideElement successMessage = $x("//h3[text()='Payment Done!']");

    public SuccessPaymentPage verifySuccessPaymentMessagePresence() {
        waitForElementToBeVisible(successMessage, "Success Payment message");
        return this;
    }
}

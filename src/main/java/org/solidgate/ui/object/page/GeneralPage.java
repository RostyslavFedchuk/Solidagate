package org.solidgate.ui.object.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class GeneralPage {

    public String getCurrentWebPageUrl() {
        return WebDriverRunner.url();
    }

    public void fillVisibleInputField(SelenideElement element, String value, String fieldName) {
        element.as(fieldName)
                .shouldBe(visible)
                .sendKeys(value);
    }

    public void clickOnVisibleElement(SelenideElement element, String fieldName) {
        element.as(fieldName)
                .shouldBe(enabled)
                .click();
    }

    public void waitForElementToBeVisible(SelenideElement element, String fieldName) {
        element.as(fieldName)
                .shouldBe(visible);
    }
}

package org.solidgate.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

import static java.lang.String.format;
import static org.solidgate.util.constansts.ValidationConstants.INVALID_FIELD_VALUE_ERROR_MESSAGE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidatorManager {

    public static <T> void verifyFieldValue(String fieldName, T actualValue, T expectedValue, SoftAssert softAssert) {
        String errorMessage = format(INVALID_FIELD_VALUE_ERROR_MESSAGE, fieldName, expectedValue, actualValue);
        softAssert.assertEquals(actualValue, expectedValue, errorMessage);
    }
}

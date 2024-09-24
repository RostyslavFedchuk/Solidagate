package org.solidgate.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.solidgate.api.model.CreditCard;
import org.solidgate.api.model.Payment;

import java.util.UUID;

import static org.solidgate.util.FileUtils.getObjectFromFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataProvider {

    private static final String PAYMENT_DATA_FILE_PATH = "data/payment_data.json";
    private static final String CREDIT_CARD_DATA_FILE_PATH = "data/credit_card_data.json";

    public static Payment getDefaultPaymentModel() {
        Payment payment = getObjectFromFile(PAYMENT_DATA_FILE_PATH, Payment.class);
        payment.getOrder().setOrderId(UUID.randomUUID().toString());
        return payment;
    }

    public static CreditCard getDefaultCreditCardModel() {
        return getObjectFromFile(CREDIT_CARD_DATA_FILE_PATH, CreditCard.class);
    }
}

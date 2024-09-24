package org.solidgate.util.constansts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonConstants {

    //Headers
    public static final String MERCHANT_HEADER = "merchant";
    public static final String SIGNATURE_HEADER = "signature";

    //Endpoints
    public static final String INIT_ENDPOINT = "/init";
    public static final String STATUS_ENDPOINT = "/status";

    //Json keys
    public static final String ORDER_ID_KEY = "order_id";
    public static final String URL_KEY = "url";

    public static final String SUCCESS_STRING = "success";

    //fields
    public static final String ORDER_AMOUNT_FIELD = "Order Amount";
    public static final String ORDER_CURRENCY_FIELD = "Order Currency";
    public static final String TRANSACTION_STATUS_FIELD = "Transaction Status";
    public static final String CARD_NUMBER_FIELD = "Card Number";
    public static final String CARD_CVV_FIELD = "Card CVV";
    public static final String CARD_HOLDER_FIELD = "Card Holder";
    public static final String PAY_BUTTON_FIELD = "Pay button";
    public static final String CARD_EXPIRY_DATE_FIELD = "Card Expiry date";
}

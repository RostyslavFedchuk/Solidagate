package org.solidgate.api.model;

import lombok.Data;

@Data
public class CreditCard {

    private String testId;
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String cardHolder;
}

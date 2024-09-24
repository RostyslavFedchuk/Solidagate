package org.solidgate.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Transaction {
    private String id;
    private String operation;
    private String status;
    private String descriptor;
    private int amount;
    private String currency;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("marketing_amount")
    private int marketingAmount;
    @JsonProperty("marketing_currency")
    private String marketingCurrency;
    private Object card;
    @JsonProperty("card_token")
    private Object cardToken;
}

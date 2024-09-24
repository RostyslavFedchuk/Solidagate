package org.solidgate.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.solidgate.api.model.Order;
import org.solidgate.api.model.OrderMetadata;

import java.util.Map;

@Data
public class OrderStatusResponse {
    private Order order;
    @JsonProperty("pay_form")
    private Object payForm;
    @JsonProperty("payment_adviser")
    private Object paymentAdviser;
    @JsonProperty("order_metadata")
    private OrderMetadata orderMetadata;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("device_info")
    private Object deviceInfo;
    private Map<String, Transaction> transactions;
    @JsonProperty("three_ds")
    private Map<String, Object> threeDs;
    private Object routing;

    public String getTransActionStatus() {
        return transactions.values().stream()
                .findFirst()
                .get()
                .getStatus();
    }
}

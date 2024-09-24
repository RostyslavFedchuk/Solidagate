package org.solidgate.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderMetadata {

    @JsonProperty("coupon_code")
    private String couponCode;
    @JsonProperty("partner_id")
    private String partnerId;
}

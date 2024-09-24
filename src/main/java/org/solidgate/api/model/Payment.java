package org.solidgate.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Payment {

    @JsonProperty("page_customization")
    private PageCustomization pageCustomization;
    @JsonProperty("order")
    private Order order;
}

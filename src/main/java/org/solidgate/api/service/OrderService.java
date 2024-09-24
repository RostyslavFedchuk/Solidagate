package org.solidgate.api.service;

import io.restassured.response.Response;
import org.solidgate.util.PropertyManager;

import java.util.Map;

import static org.solidgate.util.constansts.CommonConstants.ORDER_ID_KEY;
import static org.solidgate.util.constansts.CommonConstants.STATUS_ENDPOINT;

public class OrderService extends BaseService {

    public OrderService() {
        super(PropertyManager.getPayApiBaseUrl());
    }

    public Response getOrderStatus(String orderId) {
        Map<String, String> requestBody = Map.of(ORDER_ID_KEY, orderId);
        return restClient.postWithAuth(STATUS_ENDPOINT, requestBody);
    }
}

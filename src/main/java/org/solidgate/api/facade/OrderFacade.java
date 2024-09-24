package org.solidgate.api.facade;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.solidgate.api.model.Order;
import org.solidgate.api.model.response.OrderStatusResponse;
import org.solidgate.api.service.OrderService;

import static org.apache.http.HttpStatus.SC_OK;

public class OrderFacade {

    private final OrderService orderService;

    public OrderFacade() {
        orderService = new OrderService();
    }

    public OrderStatusResponse getOrderStatus(String orderId) {
        return orderService.getOrderStatus(orderId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(OrderStatusResponse.class);
    }
}

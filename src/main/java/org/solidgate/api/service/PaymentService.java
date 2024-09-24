package org.solidgate.api.service;

import io.restassured.response.Response;
import org.solidgate.api.model.Payment;
import org.solidgate.util.PropertyManager;

import static org.solidgate.util.constansts.CommonConstants.INIT_ENDPOINT;

public class PaymentService extends BaseService {

    public PaymentService() {
        super(PropertyManager.getPaymentApiBaseUrl());
    }

    public Response createPaymentPage(Payment payment) {
        return restClient.postWithAuth(INIT_ENDPOINT, payment);
    }
}

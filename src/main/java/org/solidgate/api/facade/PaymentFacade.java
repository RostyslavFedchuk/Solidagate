package org.solidgate.api.facade;

import org.solidgate.api.model.Payment;
import org.solidgate.api.service.PaymentService;

import static org.apache.http.HttpStatus.SC_OK;
import static org.solidgate.util.constansts.CommonConstants.URL_KEY;

public class PaymentFacade {

    private final PaymentService paymentService;

    public PaymentFacade() {
        paymentService = new PaymentService();
    }

    public String createPaymentPageUrl(Payment payment) {
        return paymentService.createPaymentPage(payment)
                .then()
                .statusCode(SC_OK)
                .extract()
                .jsonPath()
                .getString(URL_KEY);
    }
}

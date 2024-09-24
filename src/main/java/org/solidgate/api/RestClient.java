package org.solidgate.api;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Arrays.stream;
import static org.solidgate.util.FileUtils.getObjectAsJsonString;
import static org.solidgate.util.SignatureGenerator.generateHashSignature;
import static org.solidgate.util.constansts.CommonConstants.MERCHANT_HEADER;
import static org.solidgate.util.constansts.CommonConstants.SIGNATURE_HEADER;

@AllArgsConstructor
public class RestClient {

    private final String baseUri;
    private final String publicKey;
    private final String secretKey;

    public Response postWithAuth(String uri, Object body) {
        return getAuthRequestSpecification(body)
                .body(body)
                .when().post(uri)
                .then().log().all()
                .extract().response();
    }

    private RequestSpecification getAuthRequestSpecification(Object requestBody) {
        config = new RestAssuredConfig().encoderConfig(new EncoderConfig().defaultContentCharset(UTF_8));
        return given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .headers(createAuthHeaders(requestBody))
                .baseUri(baseUri)
                .log().all();
    }

    private Map<String, String> createAuthHeaders(Object requestBody) {
        String jsonRequestBody = getObjectAsJsonString(requestBody);
        String signatureHeaderValue = generateHashSignature(publicKey, jsonRequestBody, secretKey);
        return Map.of(MERCHANT_HEADER, publicKey, SIGNATURE_HEADER, signatureHeaderValue);
    }
}

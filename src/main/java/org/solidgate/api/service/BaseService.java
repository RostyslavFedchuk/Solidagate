package org.solidgate.api.service;

import org.solidgate.api.RestClient;
import org.solidgate.util.PropertyManager;

public abstract class BaseService {

    protected RestClient restClient;

    public BaseService(String baseUri) {
        restClient = new RestClient(baseUri, PropertyManager.getPublicKey(), PropertyManager.getSecretKey());
    }
}

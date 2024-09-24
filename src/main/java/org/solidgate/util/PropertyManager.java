package org.solidgate.util;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Properties;

import static java.lang.String.format;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class PropertyManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        initProperties();
    }

    public static String getPublicKey() {
        return getProperty("public.key");
    }

    public static String getSecretKey() {
        return getProperty("secret.key");
    }

    public static String getPaymentApiBaseUrl() {
        return getProperty("payment.api.base.url");
    }

    public static String getPayApiBaseUrl() {
        return getProperty("pay.api.base.url");
    }

    @SneakyThrows
    private static void initProperties() {
        PROPERTIES.load(PropertyManager.class.getClassLoader().getResourceAsStream("common.properties"));
    }

    private static String getProperty(String key) {
        if (PROPERTIES.containsKey(key)) {
            return PROPERTIES.getProperty(key);
        } else if (System.getProperties().containsKey(key)) {
            return System.getProperty(key);
        } else {
            throw new RuntimeException(format("'%s' property was not found: ", key));
        }
    }
}

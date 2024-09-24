package org.solidgate.util;

import com.google.common.hash.Hashing;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.lang.String.join;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SignatureGenerator {

    public static String generateHashSignature(String publicKey, String jsonString, String secretKey) {
        String text = join(EMPTY, publicKey, jsonString, publicKey);
        byte[] hashedBytes = Hashing.hmacSha512(secretKey.getBytes())
                .hashString(text, StandardCharsets.UTF_8)
                .toString()
                .getBytes();
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
}

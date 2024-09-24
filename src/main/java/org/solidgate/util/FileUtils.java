package org.solidgate.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows(IOException.class)
    public static String getObjectAsJsonString(Object body) {
        return OBJECT_MAPPER.writeValueAsString(body);
    }

    @SneakyThrows(IOException.class)
    public static <T> T getObjectFromFile(String filePath, Class<T> type) {
        return OBJECT_MAPPER.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream(filePath), type);
    }
}

package org.climate_data_api.config;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ConfigLoader {

    public String getApiKey() {
        String resourceName = "api-key.txt";

        ClassLoader classLoader = getClass().getClassLoader(); //procurar no classpath
        try (InputStream inputStream = classLoader.getResourceAsStream(resourceName)) { //encontrando o arquivo da key (src/main/resources)

            if (inputStream == null) {
                throw new RuntimeException("File not found.");
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8).trim();

        } catch (Exception e) {
            throw new RuntimeException("Fail to read resources: " + e.getMessage());
        }
    }
}

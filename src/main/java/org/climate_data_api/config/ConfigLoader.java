package org.climate_data_api.config;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ConfigLoader {

    public String getApiKey() {
        String resourceName = "api_key.txt";

        ClassLoader classLoader = getClass().getClassLoader(); //procurar no classpath (src/main/resources)
        try (InputStream inputStream = classLoader.getResourceAsStream(resourceName)) { //encontrando o arquivo da key

            if (inputStream == null) {
                throw new RuntimeException("File not found.");
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException("Fail to read resources: " + e.getMessage());
        }
    }
}

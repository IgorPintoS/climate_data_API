package org.climate_data_api.services;

import org.climate_data_api.config.ConfigLoader;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ClimateService {

    private final ConfigLoader configLoader;

    public ClimateService(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    public String getClimateData(String city) throws Exception {
        String apiKey = configLoader.getApiKey();
        String nameCityFormated = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + nameCityFormated;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl)) //define o URI da solicitação HTTP.
                .build();

        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {  //Objeto para enviar solicitações HTTP
           response = client.send(request, HttpResponse.BodyHandlers.ofString());  //Envio da solicitação e recebimento da requsição
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body(); //retorna os dados meteriológicos
    }
}

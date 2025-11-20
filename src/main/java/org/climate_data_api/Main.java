package org.climate_data_api;

import com.google.gson.Gson;
import org.climate_data_api.DTO.WeatherResponseDTO;
import org.climate_data_api.config.ConfigLoader;
import org.climate_data_api.mapper.ClimateMapper;
import org.climate_data_api.model.Climate;
import org.climate_data_api.services.ClimateService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConfigLoader configLoader = new ConfigLoader();
        Gson gson = new Gson();
        ClimateService climateService = new ClimateService(configLoader);

        while (true) {
            System.out.println("Enter the city to check the weather: ");
            String city = scanner.nextLine();

            if (city.isEmpty()) {
                continue;
            }

            try {
                String data = climateService.getClimateData(city);
                WeatherResponseDTO dto = gson.fromJson(data, WeatherResponseDTO.class); //carrega o dto com base no json recebido

                if (dto == null) {
                    throw new RuntimeException("City not found in the response.");
                }

                Climate climate = ClimateMapper.toDomain(dto); //traduz para o modelo

                climateService.printClimateData(climate);

                System.out.println();
                System.out.println("Would you like to schedule a new climate consultation? (for exit press 'N')");
                String choice = scanner.nextLine();

                String upperChoice = choice.toUpperCase();
                if(upperChoice.equals("N")) {
                    break; //chegou ao final sai do loop
                }

            } catch (Exception e) {
                System.out.println("We were unable to retrieve the city data, please try again. " + e.getMessage());
            }
        }

        scanner.close();
    }
}

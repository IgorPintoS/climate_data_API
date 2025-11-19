package org.climate_data_api.mapper;

import org.climate_data_api.DTO.WeatherResponseDTO;
import org.climate_data_api.model.Climate;

public class ClimateMapper {

    public static Climate toDomain(WeatherResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Climate.Builder()
                .city(dto.location().name())
                .country(dto.location().country())
                .weatherCondition(dto.current().condition().text())
                .airHumidity(dto.current().humidity())
                .windSpeed(dto.current().windKph())
                .atmosphericPressure(dto.current().pressureMb())
                .windChill(dto.current().feelsLikeC())
                .currentTemperature(dto.current().tempC())
                .dateTime(dto.current().dateTime())
                .build();
    }
}

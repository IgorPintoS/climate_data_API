package org.climate_data_api.DTO;

import com.google.gson.annotations.SerializedName;

public record WeatherResponseDTO(
        @SerializedName("location")
        LocationDTO location,

        @SerializedName("current")
        CurrentDTO current
) {
}

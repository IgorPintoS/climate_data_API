package org.climate_data_api.DTO;

import com.google.gson.annotations.SerializedName;

public record CurrentDTO(
        @SerializedName("temp_c")
        double tempC,

        @SerializedName("humidity")
        Integer humidity,

        @SerializedName("wind_kph")
        double windKph,

        @SerializedName("pressure_mb")
        double pressureMb,

        @SerializedName("feelslike_c")
        double feelsLikeC,

        @SerializedName("condition")
        ConditionDTO condition,

        @SerializedName("last_updated")
        String dateTime
) {
}

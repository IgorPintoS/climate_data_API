package org.climate_data_api.DTO;

import com.google.gson.annotations.SerializedName;

public record LocationDTO(
        @SerializedName("name")
        String name,

        @SerializedName("country")
        String country
) {
}

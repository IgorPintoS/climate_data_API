package org.climate_data_api.DTO;

import com.google.gson.annotations.SerializedName;

public record ConditionDTO(
        @SerializedName("text")
        String text
) {
}

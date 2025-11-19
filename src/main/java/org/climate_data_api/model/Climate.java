package org.climate_data_api.model;

public class Climate {
    private String city;
    private String country;
    private String weatherCondition;
    private Integer airHumidity;
    private double windSpeed;
    private double atmosphericPressure;
    private double windChill;
    private double currentTemperature;
    private String dateTime;

    private Climate(Builder builder) {
        this.city = builder.city;
        this.country = builder.country;
        this.weatherCondition = builder.weatherCondition;
        this.airHumidity = builder.airHumidity;
        this.windSpeed = builder.windSpeed;
        this.atmosphericPressure = builder.atmosphericPressure;
        this.windChill = builder.windChill;
        this.currentTemperature = builder.currentTemperature;
        this.dateTime = builder.dateTime;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public Integer getAirHumidity() {
        return airHumidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public double getWindChill() {
        return windChill;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public String getDateTime() {
        return dateTime;
    }

    public static class Builder {
        private String city;
        private String country;
        private String weatherCondition;
        private Integer airHumidity;
        private double windSpeed;
        private double atmosphericPressure;
        private double windChill;
        private double currentTemperature;
        private String dateTime;

        public Builder() {
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder weatherCondition(String weatherCondition) {
            this.weatherCondition = weatherCondition;
            return this;
        }

        public Builder airHumidity(Integer airHumidity) {
            this.airHumidity = airHumidity;
            return this;
        }

        public Builder windSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Builder atmosphericPressure(double atmosphericPressure) {
            this.atmosphericPressure = atmosphericPressure;
            return this;
        }

        public Builder windChill(double windChill) {
            this.windChill = windChill;
            return this;
        }

        public Builder currentTemperature(double currentTemperature) {
            this.currentTemperature = currentTemperature;
            return this;
        }

        public Builder dateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Climate build() {
            return new Climate(this);
        }
    }
}


package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

import java.util.Arrays;

/**
 * DTO for Weather info
 */
@Data
public class WeatherInfo {

    private String city_name;
    private String country_code;
    private SmallData[] data;
    private Double lat;
    private Double lon;
    private Integer state_code;
    private String timezone;

    @Override
    public String toString() {
        return
                  "City: " + city_name + "\n"
                + "Country code: " + country_code + "\n"
                + Arrays.toString(data).replaceAll("[\\[\\]]", "\n").replaceAll(", ", "\n") + "\n"
                + "Timezone: " + timezone;
    }
}

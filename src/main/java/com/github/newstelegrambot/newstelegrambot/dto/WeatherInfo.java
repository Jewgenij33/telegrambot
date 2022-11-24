package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

import java.lang.reflect.Array;

/**
 * DTO for Weather info
 */
@Data
public class WeatherInfo {

    private String city_name;
    private String country_code;
    private Array[] data;
    private Double lat;
    private Double lon;
    private Integer state_code;
    private String timezone;
}

package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class WeatherInfo {

    private String city_name;
    private String country_code;
    private String app_max_temp;
    private String app_min_temp;
    private String clouds;
    private Date datetime;
    private Integer min_temp;
    private Integer max_temp;
    private String wind_cdir_full;
    private String wind_spd;

}

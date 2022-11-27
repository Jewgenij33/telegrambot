package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

/**
 * DTO for data class
 */
@Data
public class DataClass {

    private Integer clouds;
    private Double high_temp;
    private Double low_temp;
    private Double temp;
//    private Weather weather;
    private String wind_cdir_full;
    private Double wing_gust_spd;
    private Double wind_spd;

}

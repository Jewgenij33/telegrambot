package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

@Data
public class SmallData {

    // TODO: 27/11/2022 Exception JSON Date class
//    private Date datetime;
    private String clouds;
    private String dewpt;
    private String hight_temp;
    private String low_temp;
    private String max_temp;
    private String min_temp;
    private String temp;
    private Weather weather;

}

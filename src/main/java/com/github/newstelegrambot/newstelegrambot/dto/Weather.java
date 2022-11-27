package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

@Data
public class Weather {

    private Integer code;
    private String icon;
    private String description;

}

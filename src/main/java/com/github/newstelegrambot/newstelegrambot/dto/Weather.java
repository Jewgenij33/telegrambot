package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

@Data
public class Weather {

    private Integer code;
    private String icon;
    private String description;

    @Override
    public String toString() {
        return    "code: " + code + "\n"
                + "icon: " +icon + "\n"
                + "description: " + description;

    }

}

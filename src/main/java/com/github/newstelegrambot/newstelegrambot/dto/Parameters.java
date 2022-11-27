package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

@Data
public class Parameters {

    private final Double lat;
    private final Double lon;
    private final Integer days;
    private final String KEY;
}

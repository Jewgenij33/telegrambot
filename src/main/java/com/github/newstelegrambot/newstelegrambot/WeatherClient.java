package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;

import java.util.List;

public interface WeatherClient {

    /**
     * Get all fields by {@link WeatherInfo}
     */

    List <WeatherInfo> getParamRequests(ParamRequests paramRequests);
}

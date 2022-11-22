package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;

public interface WeatherClient {

    /**
     * Get all fields by {@link WeatherInfo}
     *
     * @return
     */

    WeatherInfo getParamRequests(ParamRequests paramRequests);


}

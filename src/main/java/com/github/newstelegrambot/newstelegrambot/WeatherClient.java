package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.SmallData;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;

public interface WeatherClient {


    /**
     * Get all fields by {@link WeatherInfo}
     *
     */

    WeatherInfo getParamRequests(ParamRequests paramRequests);
    SmallData getDataInfo (WeatherInfo weatherInfo, int day);

}

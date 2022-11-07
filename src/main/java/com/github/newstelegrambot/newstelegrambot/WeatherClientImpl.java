package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of the {@link WeatherClient} interface.
 */

@Component
public class WeatherClientImpl implements WeatherClient{

    private final String weatherApiPath;

    public WeatherClientImpl(@Value("${weather.api.path}") String weatherApi) {
        this.weatherApiPath = weatherApi;
    }

    @Override
    public List<WeatherInfo> getParamRequests(@NotNull ParamRequests paramRequests) {
        return Unirest.get(weatherApiPath)
                .queryString(paramRequests.populateQueries())
                .asObject(new GenericType<List<WeatherInfo>>(){})
                .getBody();
    }
}

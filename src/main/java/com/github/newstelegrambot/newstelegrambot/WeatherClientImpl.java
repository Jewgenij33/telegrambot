package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.SmallData;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;
import com.google.gson.Gson;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link WeatherClient} interface.
 */

@Component
public class WeatherClientImpl implements WeatherClient{

    private final String weatherUrl;
    public WeatherClientImpl(@Value("${weather.url}")
                             String weatherUrl) {
        this.weatherUrl = weatherUrl;}

    @Override
    public WeatherInfo getParamRequests(
                         @NotNull ParamRequests paramRequests) {

       return Unirest.get(weatherUrl)
               .queryString(paramRequests.populateQueries())
               .asObject(new GenericType<WeatherInfo>(){
                })
               .getBody();
    }

    @Override
    public SmallData getDataInfo(WeatherInfo weatherInfo, int day) {

        JSONObject jsonObject = new JSONObject(weatherInfo);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        Gson gson = new Gson();
        JSONObject object = jsonArray.getJSONObject(day);

        return gson.fromJson(object.toString(), SmallData.class);

    }
}

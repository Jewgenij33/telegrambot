package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Data;

/**
 * get data from array {@link WeatherInfo}
 */
@Data
public class SmallData {

    private String datetime;
    private String clouds;
    private String dewpt;
    private String high_temp;
    private String low_temp;
    private String max_temp;
    private String min_temp;
    private String temp;
    private Weather weather;

    @Override
    public String toString() {
        return      "date: " + datetime + "\n"
                + "clouds: " + clouds + "\n"
                + "dewpt: " + dewpt + "\n"
                + "high temperature: " + high_temp + "\n"
                + "low temperature: " + low_temp + "\n"
                + "max temperature: " +max_temp + "\n"
                + "min temperature: " + min_temp + "\n"
                + "temperature: " + temp + "\n"
                + "weather: " + weather + "\n";

    }

}

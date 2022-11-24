package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Integration-level testing for WeatherClientImplTest")
class WeatherClientImplTest {

    private final WeatherClient client = new WeatherClientImpl("http://api.weatherbit.io/v2.0/forecast/daily");

    @Test
    public void shouldGetCurrentWeather(){
        //given
        ParamRequests param = ParamRequests.builder()
                .lat(52.279587)
                .days(7)
                .lon(21.117054)
                .KEY("55cc77d1c9b04e60937a575f545b607f")
                .build();

        //when
        List<WeatherInfo> weatherInfoList = client.getParamRequests(param);

        //then
//        Assertions.assertNotNull(weatherInfoList);
//        Assertions.assertFalse(weatherInfoList.isEmpty());

        System.out.println(weatherInfoList);
    }
}
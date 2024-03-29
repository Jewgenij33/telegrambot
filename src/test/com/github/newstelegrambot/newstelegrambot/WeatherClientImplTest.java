package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.dto.SmallData;
import com.github.newstelegrambot.newstelegrambot.dto.WeatherInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Integration-level testing for WeatherClientImplTest")
class WeatherClientImplTest {

    private final WeatherClient client = new WeatherClientImpl("http://api.weatherbit.io/v2.0/forecast/daily");
    WeatherInfo weatherInfo;
    SmallData smallData;
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
        weatherInfo = client.getParamRequests(param);

        //then
        Assertions.assertNotNull(weatherInfo);
        Assertions.assertNotNull(weatherInfo, "city_name=Ząbki");
        System.out.println(weatherInfo);
    }
    @Test
    public void showMeWeatherTomorrow(){
        shouldGetCurrentWeather();
        smallData = client.getDataInfo(weatherInfo, 5);

        System.out.println(smallData);
    }
}
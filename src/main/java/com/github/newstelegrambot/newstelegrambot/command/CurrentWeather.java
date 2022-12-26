package com.github.newstelegrambot.newstelegrambot.command;

import com.github.newstelegrambot.newstelegrambot.WeatherClient;
import com.github.newstelegrambot.newstelegrambot.WeatherClientImpl;
import com.github.newstelegrambot.newstelegrambot.dto.ParamRequests;
import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Current {@link Command}
 */
public class CurrentWeather implements Command{

    private final SendBotMessageService sendBotMessageService;
    TelegramUserService telegramUserService;
    public static String CURRENT_WEATHER;
    WeatherClient weatherClient = new WeatherClientImpl("https://api.weatherbit.io/v2.0/forecast/daily");

    public CurrentWeather (SendBotMessageService sendBotMessageService,
                           TelegramUserService telegramUserService){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        CURRENT_WEATHER = weatherClient.getParamRequests(ParamRequests.builder()
                .lat(52.204767)
                .lon(21.067853)
                .days(1)
                .KEY("55cc77d1c9b04e60937a575f545b607f")
                .build()).toString();

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                        CURRENT_WEATHER);
    }

}

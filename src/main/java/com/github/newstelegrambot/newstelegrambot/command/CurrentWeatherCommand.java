package com.github.newstelegrambot.newstelegrambot.command;

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command which return current weather forecast
 */
public class CurrentWeatherCommand implements Command {

    private SendBotMessageService sendBotMessageService;

    private TelegramUserService telegramUserService;

    public CurrentWeatherCommand(SendBotMessageService sendBotMessageService,
                                 TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
    }
}

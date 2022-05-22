package com.github.newstelegrambot.newstelegrambot.command;

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StatCommand implements Command {

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    public final static String STAT_MESSAGE = "This telegrambot's employing %s users";

    @Autowired
    public StatCommand(SendBotMessageService sendBotMessageService,
                       TelegramUserService telegramUserService){
        this.telegramUserService = telegramUserService;
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        int activeUsersCount = telegramUserService.retrieveAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                String.format(STAT_MESSAGE, activeUsersCount));

    }
}

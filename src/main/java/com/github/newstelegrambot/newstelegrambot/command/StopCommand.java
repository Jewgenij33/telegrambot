package com.github.newstelegrambot.newstelegrambot.command;

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "I'm deactivated all you subscriptions \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService,
                            TelegramUserService telegramUserService){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(user -> {
                    user.setActive(false);
                    telegramUserService.save(user);
                });
    }
}
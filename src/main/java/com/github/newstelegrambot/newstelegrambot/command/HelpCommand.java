package com.github.newstelegrambot.newstelegrambot.command;

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import static com.github.newstelegrambot.newstelegrambot.command.CommandName.*;

/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>available commands</b>✨\n\n"

                    + "<b>Start\\stop work with bot </b>\n"
                    + "%s - start of work with me\n"
                    + "%s - stop of work with me\n\n"
                    + "%s - get help working with me\n"
                    + "%s - count active users \n\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName(), STAT.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}

package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.command.Command;
import com.github.newstelegrambot.newstelegrambot.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.newstelegrambot.newstelegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
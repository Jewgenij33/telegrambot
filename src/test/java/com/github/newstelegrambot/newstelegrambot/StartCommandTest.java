package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.command.Command;
import com.github.newstelegrambot.newstelegrambot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.newstelegrambot.newstelegrambot.command.CommandName.START;
import static com.github.newstelegrambot.newstelegrambot.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}

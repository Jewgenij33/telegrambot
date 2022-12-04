package com.github.newstelegrambot.newstelegrambot.command

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@DisplayName("Unit-testing for CommandContainer")
class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    void init() {

        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService)
    }

    @Test
    public void shouldGetRunAllExistCommands() {

        List<Command> commands = new ArrayList<Command>();
        for (Command command : commands) {
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        }
    }

    @Test
    public void shouldReturnUnknownCommand() {

        String unknownCommand = "/asdgsgda";
        Command command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
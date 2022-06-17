package com.github.newstelegrambot.newstelegrambot.command

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@DisplayName("Unit-testing for CommandContainer")
@ExtendWith(MockitoExtension.class)
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @Mock
    TelegramUserService telegramUserService;
    SendBotMessageService sendBotMessageService;

    @BeforeEach
    public void init() {

//        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
//        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService);

    }

    @Test
    public void shouldGetRunAllExistCommands() {

        List<Command> commands = new ArrayList<Command>();
        for (Command command : commands) {
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        }
    }

    @Test
    void shouldReturnUnknownCommand() {

        String unknownCommand = "/asdgsgda"
        Command command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());

    }
}
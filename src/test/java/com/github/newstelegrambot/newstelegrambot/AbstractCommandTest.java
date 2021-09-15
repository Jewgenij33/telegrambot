package com.github.newstelegrambot.newstelegrambot;

import com.github.newstelegrambot.newstelegrambot.bot.NewTelegramBot;
import com.github.newstelegrambot.newstelegrambot.command.Command;
import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Abstract class for testing {@link Command}s.
 */
abstract class AbstractCommandTest {

    protected NewTelegramBot newTelegramBot = Mockito.mock(NewTelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(newTelegramBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {

        Long chatId = 1234567824356L;

        Update update = new Update();
        Message messageMock = Mockito.mock(Message.class);
        Mockito.when(messageMock.getChatId()).thenReturn(chatId);
        Mockito.when(messageMock.getText()).thenReturn(getCommandName());
        update.setMessage(messageMock);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(newTelegramBot).execute(sendMessage);
    }
}
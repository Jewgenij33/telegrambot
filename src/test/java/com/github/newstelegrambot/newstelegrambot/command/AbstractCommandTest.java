package com.github.newstelegrambot.newstelegrambot.command;


import com.github.newstelegrambot.newstelegrambot.bot.NewTelegramBot;
import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageServiceImpl;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
abstract class AbstractCommandTest {


    protected NewTelegramBot telegramBot;
    protected SendBotMessageService sendBotMessageService;

    @NotNull
    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @BeforeEach
    public void unit(){

        telegramBot = Mockito.mock(NewTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(telegramBot);
    }

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;
        String text = getCommandName();

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        when(message.getChatId()).thenReturn(chatId);
        message.getText();
        //        when(message.getText()).thenReturn(getCommandName());
        //        doReturn(getCommandName()).when(message.getText());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
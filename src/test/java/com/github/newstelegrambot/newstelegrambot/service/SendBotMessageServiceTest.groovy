package com.github.newstelegrambot.newstelegrambot.service

import com.github.newstelegrambot.newstelegrambot.bot.NewTelegramBot
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

@DisplayName("Unit-testing for SendMessageServiceTest")
class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;

    private NewTelegramBot newTelegramBot;

    @BeforeEach
    void unit(){
        newTelegramBot = Mockito.mock(NewTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(newTelegramBot);
        }

    @Test
    void shouldPropertySendMessage() {

        String chatId = 12345L;
        String message = "some message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(newTelegramBot).execute(sendMessage);
    }
}

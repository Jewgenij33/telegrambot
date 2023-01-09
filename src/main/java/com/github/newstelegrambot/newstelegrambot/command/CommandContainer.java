package com.github.newstelegrambot.newstelegrambot.command;

import com.github.newstelegrambot.newstelegrambot.service.SendBotMessageService;
import com.github.newstelegrambot.newstelegrambot.service.TelegramUserService;
import com.github.newstelegrambot.newstelegrambot.WeatherClient;
import com.google.common.collect.ImmutableMap;

import static com.github.newstelegrambot.newstelegrambot.command.CommandName.*;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService,
                            TelegramUserService telegramUserService,
                            WeatherClient weatherClient){

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService,
                                                                 telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService,
                                                                 telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService,
                                                                telegramUserService))
                .put(CURRENT_WEATHER.getCommandName(), new CurrentWeather(sendBotMessageService,
                        telegramUserService, weatherClient))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }


    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}

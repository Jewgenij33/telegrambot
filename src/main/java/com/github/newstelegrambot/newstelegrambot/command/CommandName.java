package com.github.newstelegrambot.newstelegrambot.command;
/**
 * Enumeration for {@link Command}'s.
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    STAT("/stat"),
    CURRENT_WEATHER("/current"),
    WEATHER_14_DAYS("/what_will_be"),
    NO("/");


    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}
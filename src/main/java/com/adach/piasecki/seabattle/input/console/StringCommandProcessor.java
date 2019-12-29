package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandProcessor;

public class StringCommandProcessor implements CommandProcessor {

    @Override
    public Command processCommand(final String input) {
        return new Command(Character.toUpperCase(input.charAt(0)), Integer.parseInt(input.substring(1)));
    }
}

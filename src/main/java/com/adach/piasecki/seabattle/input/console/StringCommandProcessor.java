package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandProcessor;

public class StringCommandProcessor implements CommandProcessor {

    @Override
    public Command processCommand(final String input) {
        // TODO validate input based on board width and height (possible columns and rows)!
        return new Command(Character.toUpperCase(input.charAt(0)), Integer.parseInt(input.substring(1)));
    }
}

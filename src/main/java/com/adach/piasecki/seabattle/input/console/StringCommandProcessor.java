package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandProcessor;

public class StringCommandProcessor implements CommandProcessor {

    @Override
    public Command processCommand(String input) {
        return new Command(input.charAt(0), Integer.parseInt(input.substring(1)) - 1);
    }
}

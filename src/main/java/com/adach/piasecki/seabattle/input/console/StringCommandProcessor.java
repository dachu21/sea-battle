package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandProcessor;

import static com.adach.piasecki.seabattle.output.console.AsciiCodes.A_ASCII_CODE;
import static com.adach.piasecki.seabattle.output.console.AsciiCodes.ZERO_ASCII_CODE;

public class StringCommandProcessor implements CommandProcessor {

    @Override
    public Command processCommand(String input) {
        return new Command(input.charAt(0) - A_ASCII_CODE, input.charAt(1) - ZERO_ASCII_CODE - 1);
    }
}

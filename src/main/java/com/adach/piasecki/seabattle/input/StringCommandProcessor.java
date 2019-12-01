package com.adach.piasecki.seabattle.input;

public class StringCommandProcessor implements CommandProcessor {

    private static final int ZERO_ASCII_CODE = 48;

    private static final int A_ASCII_CODE = 65;

    @Override
    public Command processCommand(String input) {
        return new Command(input.charAt(0) - A_ASCII_CODE, input.charAt(1) - ZERO_ASCII_CODE - 1);
    }
}

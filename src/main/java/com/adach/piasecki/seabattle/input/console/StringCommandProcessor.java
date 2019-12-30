package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandProcessor;

public class StringCommandProcessor implements CommandProcessor {

    @Override
    public Command processCommand(final String input) throws InvalidInputException {
        char column = parseColumn(input);
        int row = parseRow(input);
        return new Command(column, row);
    }

    private char parseColumn(final String input) throws InvalidInputException {
        char column = Character.toUpperCase(input.charAt(0));
        if (!Character.isLetter(column)) {
            throw new InvalidInputException("First character of command have to be letter!");
        }
        return column;
    }

    private int parseRow(final String input) throws InvalidInputException {
        try {
            return Integer.parseInt(input.substring(1));
        } catch (IndexOutOfBoundsException | NumberFormatException ex) {
            throw new InvalidInputException("Second and next characters of command have to be number!", ex);
        }
    }
}

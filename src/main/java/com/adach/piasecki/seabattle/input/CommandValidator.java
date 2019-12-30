package com.adach.piasecki.seabattle.input;

import com.adach.piasecki.seabattle.exception.InvalidCommandException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandValidator {

    private final int width;
    private final int height;

    public void validate(final Command command) throws InvalidCommandException {
        validateColumn(command);
        validateRow(command);
    }

    private void validateColumn(final Command command) throws InvalidCommandException {
        if (command.getColumn() < 'A' || command.getColumn() >= 'A' + width) {
            throw new InvalidCommandException("Column is not in range!");
        }
    }

    private void validateRow(final Command command) throws InvalidCommandException {
        if (command.getRow() < 0 || command.getRow() >= height) {
            throw new InvalidCommandException("Row is not in range!");
        }
    }
}

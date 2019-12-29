package com.adach.piasecki.seabattle.input;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandValidator {

    private final int width;
    private final int height;

    public boolean validate(final Command command) {
        if (command.getColumn() < 'A' || command.getColumn() >= 'A' + width) {
            return false;
        }
        return command.getRow() >= 0 && command.getRow() < height;
    }
}

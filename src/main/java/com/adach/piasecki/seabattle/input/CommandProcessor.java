package com.adach.piasecki.seabattle.input;

import com.adach.piasecki.seabattle.exception.InvalidInputException;

public interface CommandProcessor {

    Command processCommand(String input) throws InvalidInputException;
}

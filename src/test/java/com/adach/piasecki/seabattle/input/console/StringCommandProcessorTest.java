package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.input.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCommandProcessorTest {

    private final StringCommandProcessor stringCommandProcessor = new StringCommandProcessor();

    @Test
    void shouldReturnCommandBaseOnInput() throws InvalidInputException {
        String input = "K8";
        Command command = stringCommandProcessor.processCommand(input);
        assertEquals('K', command.getColumn());
        assertEquals(8, command.getRow());
    }

    @Test
    void shouldMapColumnToUppercase() throws InvalidInputException {
        String input = "c9";
        Command command = stringCommandProcessor.processCommand(input);
        assertEquals('C', command.getColumn());
        assertEquals(9, command.getRow());
    }

    @Test
    void shouldThrowExceptionForInvalidColumn() {
        String input = "!9";
        assertThrows(InvalidInputException.class, () -> {
            Command command = stringCommandProcessor.processCommand(input);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidRow() {
        String input = "C!";
        assertThrows(InvalidInputException.class, () -> {
            Command command = stringCommandProcessor.processCommand(input);
        });
    }
}

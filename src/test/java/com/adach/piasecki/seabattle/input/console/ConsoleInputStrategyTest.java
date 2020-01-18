package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.input.Command;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleInputStrategyTest {

    @Test
    void shouldReturnCommandBaseOnInput() throws InvalidInputException {
        String input = "C7\r\n";
        InputStream systemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            try (ConsoleInputStrategy consoleInputStrategy = new ConsoleInputStrategy()) {
                Command command = consoleInputStrategy.waitForInput();
                assertEquals('C', command.getColumn());
                assertEquals(7, command.getRow());
            }
        } finally {
            System.setIn(systemIn);
        }
    }

    @Test
    void shouldThrowExceptionForInvalidInput() {
        String input = "!invalid\r\n";
        InputStream systemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            try (ConsoleInputStrategy consoleInputStrategy = new ConsoleInputStrategy()) {
                assertThrows(InvalidInputException.class, () -> {
                    Command command = consoleInputStrategy.waitForInput();
                });
            }
        } finally {
            System.setIn(systemIn);
        }
    }
}

package com.adach.piasecki.seabattle.input;

import com.adach.piasecki.seabattle.exception.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandValidatorTest {

    private final CommandValidator commandValidator = new CommandValidator(2, 2);

    @Test
    void shouldNotThrowExceptionForValidCommand() throws InvalidCommandException {
        commandValidator.validate(new Command('B', 1));
    }

    @Test
    void shouldThrowExceptionForCommandWithColumnOutOfRange() {
        assertThrows(InvalidCommandException.class, () -> {
            commandValidator.validate(new Command('C', 1));
        });
    }

    @Test
    void shouldThrowExceptionForCommandWithRowOutOfRange() {
        assertThrows(InvalidCommandException.class, () -> {
            commandValidator.validate(new Command('B', 2));
        });
    }
}

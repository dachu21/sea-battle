package com.adach.piasecki.seabattle.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    void shouldConstructValidCommand() {
        Command command = new Command('G', 7);
        Assertions.assertEquals('G', command.getColumn());
        Assertions.assertEquals(7, command.getRow());
    }
}

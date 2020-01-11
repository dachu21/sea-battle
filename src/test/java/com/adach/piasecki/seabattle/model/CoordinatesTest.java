package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinatesTest {

    @Test
    void shouldConstructValidCoordinates() {
        Coordinates coordinates = Coordinates.of('A', 5);
        Assertions.assertEquals('A', coordinates.getColumn());
        Assertions.assertEquals(5, coordinates.getRow());
    }
}
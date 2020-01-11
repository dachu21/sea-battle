package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class VerticalShipTest extends ShipTest {

    @Override
    Ship createShip() {
        return new VerticalShip('A', 0, 1);
    }

    @Test
    void shouldInitializeFieldsAfterConstruction() {
        final List<Coordinates> expectedCoordinates = List.of(
            Coordinates.of('A', 0),
            Coordinates.of('A', 1)
        );
        assertEquals(expectedCoordinates, ship.getCoordinates());
        assertEquals(2, ship.getSize());
        assertEquals(0, ship.getHits());
        assertFalse(ship.isSunk());
    }
}
package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class HorizontalShipTest extends ShipTest {

    @Override
    Ship createShip() {
        return new HorizontalShip(0, 'A', 'B');
    }

    @Test
    void shouldInitializeFieldsAfterConstruction() {
        final List<Coordinates> expectedCoordinates = List.of(
            Coordinates.of('A', 0),
            Coordinates.of('B', 0)
        );
        assertEquals(expectedCoordinates, ship.getCoordinates());
        assertEquals(2, ship.getSize());
        assertEquals(0, ship.getHits());
        assertFalse(ship.isSunk());
    }
}
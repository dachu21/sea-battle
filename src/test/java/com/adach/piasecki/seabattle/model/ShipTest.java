package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class ShipTest {

    Ship ship;

    abstract Ship createShip();

    @BeforeEach
    void setUp() {
        ship = createShip();
    }

    @Test
    void shouldIncrementHitsButNotSinkAfterShoot() {
        ship.shoot();

        assertEquals(1, ship.getHits());
        assertFalse(ship.isSunk());
    }

    @Test
    void shouldSinkAfterLastShoot() {
        ship.shoot();
        ship.shoot();

        assertEquals(2, ship.getHits());
        assertTrue(ship.isSunk());
    }
}

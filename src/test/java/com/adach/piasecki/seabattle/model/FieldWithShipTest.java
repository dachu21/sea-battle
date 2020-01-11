package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldWithShipTest extends FieldTest {

    @Override
    Field createField() {
        final Ship ship = new HorizontalShip(0, 'A', 'B');
        return new FieldWithShip(ship);
    }

    @Test
    void shouldChangeStateToHitAfterShot() {
        field.shoot();

        assertEquals(FieldState.HIT, field.getState());
    }

    @Test
    void shouldNotChangeStateAfterAlreadyShot() {
        field.shoot();

        assertEquals(FieldState.HIT, field.getState());

        field.shoot();

        assertEquals(FieldState.HIT, field.getState());
    }
}
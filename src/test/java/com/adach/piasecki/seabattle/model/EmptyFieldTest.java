package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmptyFieldTest extends FieldTest {

    @Override
    Field createField() {
        return new EmptyField();
    }

    @Test
    void shouldChangeStateToMissedAfterShot() {
        field.shoot();

        assertEquals(FieldState.MISSED, field.getState());
    }

    @Test
    void shouldNotChangeStateAfterAlreadyShot() {
        final Field field = new EmptyField();

        field.shoot();

        assertEquals(FieldState.MISSED, field.getState());

        field.shoot();

        assertEquals(FieldState.MISSED, field.getState());
    }
}
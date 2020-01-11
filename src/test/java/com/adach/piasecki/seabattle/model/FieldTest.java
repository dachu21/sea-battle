package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class FieldTest {

    Field field;

    abstract Field createField();

    @BeforeEach
    void initialize() {
        field = createField();
    }

    @Test
    void shouldHaveUnknownStateAfterCreation() {
        assertEquals(FieldState.UNKNOWN, field.getState());
    }
}

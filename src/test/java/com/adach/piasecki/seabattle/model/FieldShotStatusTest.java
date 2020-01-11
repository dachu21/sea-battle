package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FieldShotStatusTest {

    @Test
    void shouldConstructValidShotStatus() {
        FieldShotStatus fieldShotStatus =
            new FieldShotStatus(true, List.of(Coordinates.of('A', 1)));
        assertTrue(fieldShotStatus.isScored());
        assertEquals(1, fieldShotStatus.getSunkCoordinates().size());
    }
}

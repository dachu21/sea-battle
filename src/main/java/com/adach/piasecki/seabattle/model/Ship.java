package com.adach.piasecki.seabattle.model;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public abstract class Ship {

    private final int size;
    private final List<Coordinates> coordinates;
    private int hits = 0;
    private boolean sunk = false;

    Ship(final int size, final List<Coordinates> coordinates) {
        this.size = size;
        this.coordinates = Collections.unmodifiableList(coordinates);
    }

    void shoot() {
        hits++;
        if (hits == size) {
            sunk = true;
        }
    }
}

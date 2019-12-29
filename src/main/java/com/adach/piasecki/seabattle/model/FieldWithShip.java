package com.adach.piasecki.seabattle.model;

import java.util.Collections;

import static com.adach.piasecki.seabattle.model.FieldState.HIT;
import static com.adach.piasecki.seabattle.model.FieldState.UNKNOWN;

public class FieldWithShip extends Field {

    private final Ship ship;

    public FieldWithShip(Ship ship) {
        this.ship = ship;
    }

    protected FieldShotStatus shoot() {
        if (state == UNKNOWN) {
            ship.shoot();
            state = HIT;
            return ship.isSunk() ? new FieldShotStatus(true, ship.getCoordinates()) : new FieldShotStatus(true, Collections.emptyList());
        }

        return new FieldShotStatus(false, Collections.emptyList());
    }
}

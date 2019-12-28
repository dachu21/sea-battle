package com.adach.piasecki.seabattle.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.adach.piasecki.seabattle.model.FieldState.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Field {

    private final Ship ship;
    private FieldState state;

    public static Field empty() {
        return new Field(null, UNKNOWN_EMPTY);
    }

    public static Field withShip(final Ship ship) {
        return new Field(ship, UNKNOWN_SHIP);
    }

    List<Coordinates> shoot() {
        if (state == UNKNOWN_SHIP) {
            ship.shoot();
            state = HIT;
            return ship.isSunk() ? ship.getCoordinates() : Collections.emptyList();
        }

        if (state == UNKNOWN_EMPTY) {
            state = MISSED;
        }

        return Collections.emptyList();
    }

    Optional<Ship> getShip() {
        return Optional.ofNullable(ship);
    }

    FieldState getState() {
        return state;
    }

    void setStateToSunk() {
        state = SUNK;
    }
}

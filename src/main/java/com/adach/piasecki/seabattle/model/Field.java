package com.adach.piasecki.seabattle.model;

import lombok.Getter;

import static com.adach.piasecki.seabattle.model.FieldState.SUNK;
import static com.adach.piasecki.seabattle.model.FieldState.UNKNOWN;

public abstract class Field {

    @Getter
    FieldState state = UNKNOWN;

    Field() {
    }

    protected abstract FieldShotStatus shoot();

    void setStateToSunk() {
        state = SUNK;
    }
}

package com.adach.piasecki.seabattle.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.adach.piasecki.seabattle.model.FieldState.SUNK;
import static com.adach.piasecki.seabattle.model.FieldState.UNKNOWN;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class Field {

    @Getter
    FieldState state = UNKNOWN;

    abstract FieldShotStatus shoot();

    void setStateToSunk() {
        state = SUNK;
    }
}

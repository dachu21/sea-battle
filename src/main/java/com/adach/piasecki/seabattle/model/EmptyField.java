package com.adach.piasecki.seabattle.model;

import java.util.Collections;

import static com.adach.piasecki.seabattle.model.FieldState.MISSED;
import static com.adach.piasecki.seabattle.model.FieldState.UNKNOWN;

public class EmptyField extends Field {

    protected FieldShotStatus shoot() {
        if (state == UNKNOWN) {
            state = MISSED;
        }

        return new FieldShotStatus(false, Collections.emptyList());
    }
}

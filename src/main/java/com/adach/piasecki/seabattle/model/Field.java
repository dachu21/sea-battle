package com.adach.piasecki.seabattle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Field {

    private boolean occupied;
    private FieldState state;

    public enum FieldState {
        UNKNOWN, MISSED, SCORED
    }

    Field(final Field field) {
        this.occupied = field.occupied;
        this.state = field.state;
    }
}

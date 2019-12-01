package com.adach.piasecki.seabattle.model;

import lombok.Getter;

import static com.adach.piasecki.seabattle.model.FieldState.UNKNOWN;

public class Board {

    @Getter
    private final int width;

    @Getter
    private final int height;

    private boolean[][] fields;

    private FieldState[][] fieldStates;

    public Board(final int width, final int height, final boolean[][] fields) {
        this.width = width;
        this.height = height;
        this.fields = fields;
        this.fieldStates = new FieldState[width][height];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                fieldStates[i][j] = UNKNOWN;
            }
        }
    }

    public boolean getFieldAt(final int column, final int row) {
        return fields[column][row];
    }

    public void setFieldAt(final int column, final int row, boolean ship) {
        fields[column][row] = ship;
    }

    public FieldState getFieldStateAt(int column, int row) {
        return fieldStates[row][column];
    }

    public void setFieldStateAt(final int column, final int row, final FieldState fieldState) {
        fieldStates[column][row] = fieldState;
    }
}

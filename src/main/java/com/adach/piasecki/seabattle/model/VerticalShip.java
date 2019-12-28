package com.adach.piasecki.seabattle.model;


import java.util.ArrayList;
import java.util.List;

public class VerticalShip extends Ship {

    public VerticalShip(final char column, final int beginRow, final int endRow) {
        super(calculateSize(beginRow, endRow), calculateCoordinates(column, beginRow, endRow));
    }

    private static int calculateSize(final int beginRow, final int endRow) {
        return endRow - beginRow + 1;
    }

    private static List<Coordinates> calculateCoordinates(final char column, final int beginRow, final int endRow) {
        final List<Coordinates> coordinates = new ArrayList<>();
        for (int row = beginRow; row <= endRow; row++) {
            coordinates.add(Coordinates.of(column, row));
        }
        return coordinates;
    }
}

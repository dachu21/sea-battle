package com.adach.piasecki.seabattle.model;

import java.util.ArrayList;
import java.util.List;

public class HorizontalShip extends Ship {

    public HorizontalShip(final int row, final char beginColumn, final char endColumn) {
        super(calculateSize(beginColumn, endColumn), calculateCoordinates(row, beginColumn, endColumn));
    }

    private static int calculateSize(final char beginColumn, final char endColumn) {
        return endColumn - beginColumn + 1;
    }

    private static List<Coordinates> calculateCoordinates(final int row, final char beginColumn, final char endColumn) {
        final List<Coordinates> coordinates = new ArrayList<>();
        for (char column = beginColumn; column <= endColumn; column++) {
            coordinates.add(Coordinates.of(column, row));
        }
        return coordinates;
    }
}

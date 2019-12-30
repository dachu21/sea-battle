package com.adach.piasecki.seabattle.model;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Board {

    @Getter
    private final int width;
    @Getter
    private final int height;
    @Getter
    private final long shipFieldsCount;
    @Getter
    private final List<Ship> ships;

    private final Map<Character, List<Field>> fields;

    public Board(final int width, final int height, final long shipFieldsCount, final List<Ship> ships,
                 final Map<Character, List<Field>> fields) {
        this.width = width;
        this.height = height;
        this.shipFieldsCount = shipFieldsCount;
        this.fields = Collections.unmodifiableMap(fields);
        this.ships = Collections.unmodifiableList(ships);
    }

    public FieldState getFieldStateAt(final Coordinates coordinates) {
        return getFieldAt(coordinates).getState();
    }

    public boolean shootFieldAt(final Coordinates coordinates) {
        FieldShotStatus fieldShotStatus = getFieldAt(coordinates).shoot();
        if (fieldShotStatus.isScored()) {
            setFieldsToSunkState(fieldShotStatus.getSunkCoordinates());
        }
        return fieldShotStatus.isScored();
    }

    private Field getFieldAt(final Coordinates coordinates) {
        return fields.get(coordinates.getColumn()).get(coordinates.getRow());
    }

    private void setFieldsToSunkState(final List<Coordinates> sunkShipCoordinates) {
        sunkShipCoordinates.forEach(coordinates ->
            getFieldAt(coordinates).setStateToSunk());
    }
}

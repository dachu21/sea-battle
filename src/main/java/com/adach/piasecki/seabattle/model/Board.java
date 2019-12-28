package com.adach.piasecki.seabattle.model;

import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Board {

    @Getter
    private final int width;
    @Getter
    private final int height;
    @Getter
    private final long shipFieldsCount;

    private final Map<Character, List<Field>> fields;

    public Board(final int width, final int height, final Map<Character, List<Field>> fields) {
        this.width = width;
        this.height = height;
        this.fields = fields;
        this.shipFieldsCount = countShipFields();
    }

    public FieldState getFieldStateAt(final Coordinates coordinates) {
        return getFieldAt(coordinates).getState();
    }

    public void shootFieldAt(final Coordinates coordinates) {
        List<Coordinates> sunkShipCoordinates = getFieldAt(coordinates).shoot();
        setFieldsToSunkState(sunkShipCoordinates);
    }

    private long countShipFields() {
        return fields.values().stream()
            .flatMap(Collection::stream)
            .map(Field::getShip)
            .filter(Optional::isPresent)
            .count();
    }

    private Field getFieldAt(final Coordinates coordinates) {
        return fields.get(coordinates.getColumn()).get(coordinates.getRow());
    }

    private void setFieldsToSunkState(final List<Coordinates> sunkShipCoordinates) {
        sunkShipCoordinates.forEach(coordinates ->
            getFieldAt(coordinates).setStateToSunk());
    }
}

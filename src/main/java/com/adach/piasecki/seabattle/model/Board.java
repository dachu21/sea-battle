package com.adach.piasecki.seabattle.model;

import com.adach.piasecki.seabattle.model.Field.FieldState;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

    @Getter
    private final int width;

    @Getter
    private final int height;

    private Map<Character, List<Field>> fields;

    public Board(final Map<Character, List<Field>> fields) {
        this.width = fields.size();
        this.height = fields.values().stream().findFirst().get().size(); // TODO fix get
        this.fields = fields;
    }

    public List<Character> getColumnLabels() {
        return fields.keySet().stream().sorted().collect(Collectors.toUnmodifiableList());
    }

    public Field getFieldAt(final char column, final int row) {
        return new Field(fields.get(column).get(row));
    }

    public void setFieldOccupied(final char column, final int row, boolean occupied) {
        fields.get(column).get(row).setOccupied(occupied);
    }

    public void setFieldState(final char column, final int row, final FieldState fieldState) {
        fields.get(column).get(row).setState(fieldState);
    }

    public boolean noFieldsOccupied() {
        return fields.values().stream().flatMap(Collection::stream).noneMatch(Field::isOccupied);
    }
}

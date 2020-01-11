package com.adach.piasecki.seabattle.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Coordinates {

    private final char column;
    private final int row;

    public static Coordinates of(final char column, final int row) {
        return new Coordinates(column, row);
    }
}

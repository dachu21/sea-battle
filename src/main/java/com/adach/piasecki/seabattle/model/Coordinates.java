package com.adach.piasecki.seabattle.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Coordinates {

    private final char column;
    private final int row;

    public static Coordinates of(char column, int row) {
        return new Coordinates(column, row);
    }
}

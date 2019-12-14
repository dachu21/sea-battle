package com.adach.piasecki.seabattle.input;

import lombok.Getter;

@Getter
public class Command {

    public Command(char column, int row) {
        this.column = Character.toLowerCase(column);
        this.row = row;
    }

    private final char column;
    private final int row;
}

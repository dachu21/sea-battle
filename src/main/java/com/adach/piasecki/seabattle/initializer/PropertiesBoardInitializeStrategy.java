package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;

public class PropertiesBoardInitializeStrategy implements BoardInitializeStrategy {

    public Board initBoard() {
        final boolean[][] fields = new boolean[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                fields[i][j] = true;
            }
        }
        return new Board(20, 20, fields);
    }
}

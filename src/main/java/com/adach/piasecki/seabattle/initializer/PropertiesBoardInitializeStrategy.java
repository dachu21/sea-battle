package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;

public class PropertiesBoardInitializeStrategy implements BoardInitializeStrategy {

    public Board initBoard() {
        return new Board(10, 10);
    }
}

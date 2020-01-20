package com.adach.piasecki.seabattle.output;

import com.adach.piasecki.seabattle.model.Board;

public interface OutputStrategy {

    boolean drawBoard(Board board);

    boolean displayMessage(String message);
}

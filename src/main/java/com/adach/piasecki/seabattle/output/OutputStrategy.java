package com.adach.piasecki.seabattle.output;

import com.adach.piasecki.seabattle.model.Board;

public interface OutputStrategy {

    void drawBoard(Board board);

    void displayMessage(String message);
}

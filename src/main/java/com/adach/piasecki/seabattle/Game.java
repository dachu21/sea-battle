package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.DrawStrategy;

public class Game {

    private final InputStrategy inputStrategy;
    private final DrawStrategy drawStrategy;
    private GameEngine gameEngine;

    Game(InputStrategy inputStrategy, DrawStrategy drawStrategy, BoardInitializeStrategy propertiesBoardInitializeStrategy) {
        this.inputStrategy = inputStrategy;
        this.drawStrategy = drawStrategy;
        final Board board = propertiesBoardInitializeStrategy.initBoard();
        this.gameEngine = new GameEngine(board, inputStrategy, drawStrategy);
    }

    public void start() {
//        drawStrategy.drawStart();
        gameEngine.start();
    }

    public void finish() {
//        drawStrategy.drawResult();
    }
}

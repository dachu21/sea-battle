package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.OutputStrategy;

class Game {

    private final InputStrategy inputStrategy;
    private final OutputStrategy outputStrategy;
    private GameEngine gameEngine;

    Game(final InputStrategy inputStrategy, final OutputStrategy outputStrategy,
         final BoardInitializeStrategy propertiesBoardInitializeStrategy) {
        this.inputStrategy = inputStrategy;
        this.outputStrategy = outputStrategy;
        final Board board = propertiesBoardInitializeStrategy.initBoard();
        this.gameEngine = new GameEngine(board, inputStrategy, outputStrategy);
    }

    void run() {
        outputStrategy.displayMessage("Starting the game");
        gameEngine.run();
        finish();
    }

    private void finish() {
        outputStrategy.displayMessage("The result is it's over");
    }
}

package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.OutputStrategy;

public class Game {

    private final OutputStrategy outputStrategy;
    private final GameEngine gameEngine;

    public Game(final InputStrategy inputStrategy, final OutputStrategy outputStrategy,
                final BoardInitializeStrategy boardInitializeStrategy) {
        final Board board = boardInitializeStrategy.initializeBoard();
        this.outputStrategy = outputStrategy;
        this.gameEngine = new GameEngine(board, inputStrategy, outputStrategy);
    }

    public boolean run() {
        outputStrategy.displayMessage("The game is starting...");
        gameEngine.run();
        finish();
        return true;
    }

    private void finish() {
        outputStrategy.displayMessage("The game has stopped.");
    }
}

package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.OutputStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GameEngine {

    private final Board board;
    private final InputStrategy inputStrategy;
    private final OutputStrategy outputStrategy;
    private final GameLogicProcessor logicProcessor = new GameLogicProcessor();

    void run() {
        GameStatus gameStatus = initializeGameStatus();
        outputStrategy.drawBoard(board);

        while (gameStatus.getHitsLeft() > 0) {
            final Command command = inputStrategy.waitForInput();
            gameStatus = updateGameStatus(gameStatus, command);
            outputStrategy.drawBoard(board);
        }

        outputStrategy.displayMessage("You won! Total moves: " + gameStatus.getTotalMoves());
    }

    private GameStatus initializeGameStatus() {
        return new GameStatus(board.getShipFieldsCount(), 0);
    }

    private GameStatus updateGameStatus(final GameStatus currentGameStatus, final Command command) {
        return logicProcessor.processCommand(board, currentGameStatus, command);
    }
}

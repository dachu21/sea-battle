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
        outputStrategy.drawBoard(board);
        GameStatus gameStatus;

        do {
            final Command command = inputStrategy.waitForInput();
            gameStatus = updateBoard(command);
            outputStrategy.drawBoard(board);
        } while (!gameStatus.isFinished());
    }

    private GameStatus updateBoard(final Command command) {
        return logicProcessor.makeMove(board, command);
    }
}

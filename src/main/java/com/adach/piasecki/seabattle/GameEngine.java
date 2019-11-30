package com.adach.piasecki.seabattle;

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

    void run() {
        outputStrategy.draw(board);

        boolean finished = false;
        while (!finished) {
            final Command command = inputStrategy.waitForInput();
            finished = updateBoard(command);
            outputStrategy.draw(board);
        }
    }

    private boolean updateBoard(final Command command) {
        return false;
    }
}

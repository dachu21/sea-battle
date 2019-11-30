package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.DrawStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameEngine {

    private final Board board;
    private final InputStrategy inputStrategy;
    private final DrawStrategy drawStrategy;

    public void start() {
        drawStrategy.draw(board);

        boolean finished = false;

        while (!finished) {
            Command command = inputStrategy.waitForInput();
            finished = updateBoard(command);
            drawStrategy.draw(board);
        }
    }

    private boolean updateBoard(Command command) {
        return false;
    }
}

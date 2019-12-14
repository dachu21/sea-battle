package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.model.Board;

import static com.adach.piasecki.seabattle.model.FieldState.*;

class GameLogicProcessor {

    GameStatus makeMove(final Board board, final Command command) {
        int column = command.getColumn();
        int row = command.getRow();
        if (board.getFieldStateAt(column, row) != UNKNOWN) {
            return new GameStatus(false);
        }
        if (board.getFieldAt(column, row)) {
            board.setFieldAt(column, row, false);
            board.setFieldStateAt(column, row, SCORED);
        } else {
            board.setFieldStateAt(column, row, MISSED);
        }

        return new GameStatus(checkFinished(board));
    }

    private boolean checkFinished(final Board board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (board.getFieldAt(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
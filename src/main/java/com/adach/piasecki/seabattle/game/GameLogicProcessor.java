package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Field;

import static com.adach.piasecki.seabattle.model.Field.FieldState.*;

class GameLogicProcessor {

    GameStatus makeMove(final Board board, final Command command) {
        char column = command.getColumn();
        int row = command.getRow();
        Field field = board.getFieldAt(command.getColumn(), command.getRow());

        if (field.getState() != UNKNOWN) {
            return new GameStatus(false);
        }

        if (field.isOccupied()) {
            board.setFieldOccupied(column, row, false);
            board.setFieldState(column, row, SCORED);
        } else {
            board.setFieldState(column, row, MISSED);
        }

        return new GameStatus(checkFinished(board));
    }

    private boolean checkFinished(final Board board) {
        return board.noFieldsOccupied();
    }
}

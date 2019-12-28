package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Coordinates;
import com.adach.piasecki.seabattle.model.FieldState;

class GameLogicProcessor {

    GameStatus processCommand(final Board board, final GameStatus currentGameStatus, final Command command) {
        final Coordinates coordinates = Coordinates.of(command.getColumn(), command.getRow());
        final FieldState fieldState = board.getFieldStateAt(coordinates);

        switch (fieldState) {
            case UNKNOWN_SHIP:
                board.shootFieldAt(coordinates);
                return calculateNewGameStatus(currentGameStatus, true);
            case UNKNOWN_EMPTY:
                board.shootFieldAt(coordinates);
                return calculateNewGameStatus(currentGameStatus, false);
            default:
                return calculateNewGameStatus(currentGameStatus, false);
        }
    }

    private GameStatus calculateNewGameStatus(final GameStatus currentGameStatus, final boolean scored) {
        final long hitsLeft = scored ? currentGameStatus.getHitsLeft() - 1 : currentGameStatus.getHitsLeft();
        final long totalMoves = currentGameStatus.getTotalMoves() + 1;
        return new GameStatus(hitsLeft, totalMoves);
    }
}

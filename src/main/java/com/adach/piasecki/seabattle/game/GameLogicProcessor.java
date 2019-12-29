package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Coordinates;

class GameLogicProcessor {

    GameStatus processCommand(final Board board, final GameStatus currentGameStatus, final Command command) {
        final Coordinates coordinates = Coordinates.of(command.getColumn(), command.getRow());
        return calculateNewGameStatus(currentGameStatus, board.shootFieldAt(coordinates));
    }

    private GameStatus calculateNewGameStatus(final GameStatus currentGameStatus, final boolean scored) {
        final long hitsLeft = scored ? currentGameStatus.getHitsLeft() - 1 : currentGameStatus.getHitsLeft();
        final long totalMoves = currentGameStatus.getTotalMoves() + 1;
        return new GameStatus(hitsLeft, totalMoves);
    }
}

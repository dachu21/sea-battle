package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.model.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameLogicProcessorTest {

    private final GameLogicProcessor gameLogicProcessor = new GameLogicProcessor();

    @Test
    void shouldDecreaseHitsLeftAndIncreaseMoveCountWhenFieldHit() {
        Board board = mock(Board.class);
        when(board.shootFieldAt(any())).thenReturn(true);
        GameStatus currentGameStatus = new GameStatus(5, 10);
        Command command = new Command('A', 0);

        GameStatus newStatus = gameLogicProcessor.processCommand(board, currentGameStatus, command);
        assertEquals(4, newStatus.getHitsLeft());
        assertEquals(11, newStatus.getTotalMoves());
    }

    @Test
    void shouldLeaveHitsLeftAndIncreaseMoveCountWhenFieldMissed() {
        Board board = mock(Board.class);
        when(board.shootFieldAt(any())).thenReturn(false);
        GameStatus currentGameStatus = new GameStatus(5, 10);
        Command command = new Command('A', 0);

        GameStatus newStatus = gameLogicProcessor.processCommand(board, currentGameStatus, command);
        assertEquals(5, newStatus.getHitsLeft());
        assertEquals(11, newStatus.getTotalMoves());
    }
}

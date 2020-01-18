package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomBoardInitializeStrategyTest {

    private BoardInitializeStrategy boardInitializeStrategy = new RandomBoardInitializeStrategy();

    @Test
    void shouldGenerateRandomBoard() {
        Board board = boardInitializeStrategy.initializeBoard();
        assertEquals(10, board.getHeight());
        assertEquals(10, board.getWidth());
        assertEquals(8, board.getShips().size());
    }
}

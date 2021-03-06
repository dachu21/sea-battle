package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.HorizontalShip;
import com.adach.piasecki.seabattle.model.VerticalShip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomBoardInitializeStrategyTest {

    private final BoardInitializeStrategy boardInitializeStrategy = new RandomBoardInitializeStrategy();

    @Test
    void shouldGenerateRandomBoard() {
        Board board = boardInitializeStrategy.initializeBoard();
        assertEquals(10, board.getHeight());
        assertEquals(10, board.getWidth());
        assertEquals(8, board.getShips().size());

        assertEquals(4, board.getShips().stream().filter(ship -> ship instanceof VerticalShip).count());
        assertEquals(4, board.getShips().stream().filter(ship -> ship instanceof HorizontalShip).count());
    }
}

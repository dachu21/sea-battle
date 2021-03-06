package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.HorizontalShip;
import com.adach.piasecki.seabattle.model.VerticalShip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManualBoardInitializeStrategyTest {

    private final BoardInitializeStrategy boardInitializeStrategy = new ManualBoardInitializeStrategy();

    @Test
    void shouldGenerateManualBoard() {
        Board board = boardInitializeStrategy.initializeBoard();
        assertEquals(10, board.getHeight());
        assertEquals(10, board.getWidth());
        assertEquals(3, board.getShips().size());

        assertEquals(2, board.getShips().stream().filter(ship -> ship instanceof VerticalShip).count());
        assertEquals(1, board.getShips().stream().filter(ship -> ship instanceof HorizontalShip).count());
    }
}

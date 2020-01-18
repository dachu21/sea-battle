package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.EmptyField;
import com.adach.piasecki.seabattle.model.Field;
import com.adach.piasecki.seabattle.model.FieldWithShip;
import com.adach.piasecki.seabattle.model.HorizontalShip;
import com.adach.piasecki.seabattle.model.Ship;
import com.adach.piasecki.seabattle.output.OutputStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GameEngineTest {

    private GameEngine gameEngine;

    @BeforeEach
    void setUp() throws InvalidInputException {
        Board board = prepareBoard();
        InputStrategy inputStrategy = mock(InputStrategy.class);
        OutputStrategy outputStrategy = mock(OutputStrategy.class);

        doNothing()
            .when(outputStrategy).drawBoard(any());
        doNothing()
            .when(outputStrategy).displayMessage(any());
        doReturn(new Command('Z', 99),
            new Command('A', 0),
            new Command('A', 1),
            new Command('B', 0)
        ).when(inputStrategy).waitForInput();

        gameEngine = new GameEngine(board, inputStrategy, outputStrategy);
    }

    @Test
    void shouldFinishGameSuccessfully() {
        gameEngine.run();
    }

    private Board prepareBoard() {
        final Ship ship = new HorizontalShip(0, 'A', 'B');
        final List<Ship> ships = List.of(ship);
        final Map<Character, List<Field>> fields = new HashMap<>();
        fields.put('A', List.of(new FieldWithShip(ship), new EmptyField()));
        fields.put('B', List.of(new FieldWithShip(ship), new EmptyField()));
        return new Board(2, 2, 2, ships, fields);
    }
}

package com.adach.piasecki.seabattle.output.console;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.EmptyField;
import com.adach.piasecki.seabattle.model.Field;
import com.adach.piasecki.seabattle.model.FieldWithShip;
import com.adach.piasecki.seabattle.model.HorizontalShip;
import com.adach.piasecki.seabattle.model.Ship;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleOutputStrategyTest {

    private final ConsoleOutputStrategy consoleOutputStrategy = new ConsoleOutputStrategy();

    @Test
    void shouldDrawBoardSuccessfully() {
        assertTrue(consoleOutputStrategy.drawBoard(prepareBoard()));
    }

    @Test
    void shouldDisplayMessageSuccessfully() {
        assertTrue(consoleOutputStrategy.displayMessage("Some message"));
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

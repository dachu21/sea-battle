package com.adach.piasecki.seabattle.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.adach.piasecki.seabattle.model.FieldState.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        final Ship ship = new HorizontalShip(0, 'A', 'B');
        final List<Ship> ships = List.of(ship);

        final Map<Character, List<Field>> fields = new HashMap<>();
        fields.put('A', List.of(new FieldWithShip(ship), new EmptyField()));
        fields.put('B', List.of(new FieldWithShip(ship), new EmptyField()));

        board = new Board(2, 2, 2, ships, fields);
    }

    @Test
    void shouldReturnCorrectParametersAfteConstruction() {
        assertEquals(2, board.getWidth());
        assertEquals(2, board.getHeight());
        assertEquals(2, board.getShipFieldsCount());
        assertEquals(1, board.getShips().size());
    }

    @Test
    void shouldReturnCorrectFieldStatesAfterConstruction() {
        assertEquals(UNKNOWN, board.getFieldStateAt(Coordinates.of('A', 0)));
        assertEquals(UNKNOWN, board.getFieldStateAt(Coordinates.of('A', 1)));
        assertEquals(UNKNOWN, board.getFieldStateAt(Coordinates.of('B', 0)));
        assertEquals(UNKNOWN, board.getFieldStateAt(Coordinates.of('B', 1)));
    }

    @Test
    void shouldChangeFieldStatesAfterShots() {
        board.shootFieldAt(Coordinates.of('A', 1));
        assertEquals(MISSED, board.getFieldStateAt(Coordinates.of('A', 1)));

        board.shootFieldAt(Coordinates.of('B', 1));
        assertEquals(MISSED, board.getFieldStateAt(Coordinates.of('B', 1)));

        board.shootFieldAt(Coordinates.of('A', 0));
        assertEquals(HIT, board.getFieldStateAt(Coordinates.of('A', 0)));

        board.shootFieldAt(Coordinates.of('B', 0));
        assertEquals(SUNK, board.getFieldStateAt(Coordinates.of('B', 0)));
    }

    @Test
    void shouldChangeAllShipFieldStatesToSunkAfterShootingLastShipField() {
        board.shootFieldAt(Coordinates.of('A', 0));
        assertEquals(HIT, board.getFieldStateAt(Coordinates.of('A', 0)));

        board.shootFieldAt(Coordinates.of('B', 0));
        assertEquals(SUNK, board.getFieldStateAt(Coordinates.of('A', 0)));
        assertEquals(SUNK, board.getFieldStateAt(Coordinates.of('B', 0)));
    }
}
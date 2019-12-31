package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.exception.BoardFileNotFoundException;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Field;
import com.adach.piasecki.seabattle.model.HorizontalShip;
import com.adach.piasecki.seabattle.model.Ship;
import com.adach.piasecki.seabattle.model.VerticalShip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomBoardInitializeStrategy extends AbstractFileBoardInitializeStrategy {

    private static final String FILENAME = "random.txt";

    private static final String VERTICAL_SHIPS_NUMBER_PARAMETER = "vertical";
    private static final String HORIZONTAL_SHIPS_NUMBER_PARAMETER = "horizontal";
    private static final String VERTICAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE = "The width parameter is missing.";
    private static final String HORIZONTAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE = "The height parameter is missing.";

    private static final int MAX_SHIP_LENGTH = 6;

    public Board initializeBoard() {
        final int width;
        final int height;
        final int verticalShipsNumber;
        final int horizontalShipsNumber;

        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            width = readWidth(scanner);
            height = readHeight(scanner);
            verticalShipsNumber = readVerticalShipsNumber(scanner);
            horizontalShipsNumber = readHorizontalShipsNumber(scanner);
        } catch (FileNotFoundException e) {
            throw new BoardFileNotFoundException(e);
        }

        final AtomicInteger shipFieldsCount = new AtomicInteger();
        final List<Ship> shipList = generateShips(width, height, verticalShipsNumber, horizontalShipsNumber);
        final Map<Character, List<Field>> fieldMap = createFieldMap(width, height, shipList, shipFieldsCount);

        return new Board(width, height, shipFieldsCount.get(), shipList, fieldMap);
    }

    private List<Ship> generateShips(final int width, final int height, final int verticalShipsNumber,
                                     final int horizontalShipsNumber) {
        final List<Ship> shipList = new ArrayList<>();

        boolean[][] occupiedFields = new boolean[width][height];

        if (verticalShipsNumber > 0) {
            // generate first vertical ship by random
            final Ship firstShip = generateRandomVerticalShip(width, height);
            shipList.add(firstShip);
            markOccupiedFields(occupiedFields, firstShip);

            int verticalShipsGenerated = 1;
            while (verticalShipsGenerated < verticalShipsNumber) {
                for (int column = 0; column < width; column++) {
                    final Ship newShip = generateRandomVerticalShipInColumn(height, column);
                    if (checkIfShipFits(occupiedFields, newShip)) {
                        shipList.add(newShip);
                        markOccupiedFields(occupiedFields, newShip);
                        verticalShipsGenerated++;
                        break;
                    }
                }
            }
        }

        int horizontalShipsGenerated = 0;
        while (horizontalShipsGenerated < horizontalShipsNumber) {
            for (int row = 0; row < height; row++) {
                final Ship newShip = generateRandomHorizontalShipInRow(width, row);
                if (checkIfShipFits(occupiedFields, newShip)) {
                    shipList.add(newShip);
                    markOccupiedFields(occupiedFields, newShip);
                    horizontalShipsGenerated++;
                    break;
                }
            }
        }

        return shipList;
    }

    private Ship generateRandomVerticalShipInColumn(final int height, final int columnNumber) {
        int randomRow = randomIntFromRange(0, height - 1);
        char column = columnNumberToChar(columnNumber);
        int randomLength = randomIntFromRange(1, Math.min(MAX_SHIP_LENGTH, height - randomRow));
        return new VerticalShip(column, randomRow, randomRow + randomLength - 1);
    }

    private Ship generateRandomVerticalShip(final int width, final int height) {
        int randomColumnNumber = randomIntFromRange(0, width - 1);
        return generateRandomVerticalShipInColumn(height, randomColumnNumber);
    }

    private Ship generateRandomHorizontalShipInRow(final int width, final int row) {
        int randomColumnNumber = randomIntFromRange(0, width - 1);
        int randomLength = randomIntFromRange(1, Math.min(MAX_SHIP_LENGTH, width - randomColumnNumber));
        return new HorizontalShip(row, columnNumberToChar(randomColumnNumber), columnNumberToChar(randomColumnNumber + randomLength - 1));
    }

    private char columnNumberToChar(final int columnNumber) {
        return (char) ('A' + columnNumber);
    }

    private void markOccupiedFields(final boolean[][] occupiedFields, final Ship ship) {
        ship.getCoordinates().forEach(coordinates ->
            occupiedFields[coordinates.getColumn() - 'A'][coordinates.getRow()] = true);
    }

    private boolean checkIfShipFits(final boolean[][] occupiedFields, final Ship ship) {
        for (var coordinates : ship.getCoordinates()) {
            if (occupiedFields[coordinates.getColumn() - 'A'][coordinates.getRow()]) {
                return false;
            }
        }
        return true;
    }

    private int randomIntFromRange(final int min, final int max) {
        return new Random().nextInt(max - min) + min;
    }

    private int readHorizontalShipsNumber(final Scanner scanner) {
        return readParameter(scanner, HORIZONTAL_SHIPS_NUMBER_PARAMETER, HORIZONTAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE);
    }

    private int readVerticalShipsNumber(final Scanner scanner) {
        return readParameter(scanner, VERTICAL_SHIPS_NUMBER_PARAMETER, VERTICAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE);
    }
}

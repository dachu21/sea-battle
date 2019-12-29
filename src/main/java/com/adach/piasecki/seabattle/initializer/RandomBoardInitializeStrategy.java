package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.exception.BoardFileNotFoundException;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Field;
import com.adach.piasecki.seabattle.model.Ship;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomBoardInitializeStrategy extends AbstractFileBoardInitializeStrategy {

    private static final String FILENAME = "random.txt";

    private static final String VERTICAL_SHIPS_NUMBER_PARAMETER = "vertical";
    private static final String HORIZONTAL_SHIPS_NUMBER_PARAMETER = "horizontal";
    private static final String VERTICAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE = "The width parameter is missing.";
    private static final String HORIZONTAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE = "The height parameter is missing.";

    public Board initializeBoard() {
        int width;
        int height;
        int verticalShipsNumber;
        int horizontalShipsNumber;
        List<Ship> shipList;
        AtomicInteger shipFieldsCount = new AtomicInteger();

        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            width = readWidth(scanner);
            height = readHeight(scanner);
            verticalShipsNumber = readVerticalShipsNumber(scanner);
            horizontalShipsNumber = readHorizontalShipsNumber(scanner);
            shipList = generateShips(verticalShipsNumber, horizontalShipsNumber);
        } catch (FileNotFoundException e) {
            throw new BoardFileNotFoundException(e);
        }

        final Map<Character, List<Field>> fieldMap = createFieldMap(width, height, shipList, shipFieldsCount);

        return new Board(width, height, fieldMap, shipFieldsCount.get());
    }

    private List<Ship> generateShips(final int verticalShipsNumber, final int horizontalShipsNumber) {
        final List<Ship> shipList = new ArrayList<>();



        return shipList;
    }

    private int readHorizontalShipsNumber(final Scanner scanner) {
        return readParameter(scanner, HORIZONTAL_SHIPS_NUMBER_PARAMETER, HORIZONTAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE);
    }

    private int readVerticalShipsNumber(final Scanner scanner) {
        return readParameter(scanner, VERTICAL_SHIPS_NUMBER_PARAMETER, VERTICAL_SHIPS_NUMBER_NOT_PRESENT_ERROR_MESSAGE);
    }
}

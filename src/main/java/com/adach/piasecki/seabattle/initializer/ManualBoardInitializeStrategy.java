package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.exception.BoardFileNotFoundException;
import com.adach.piasecki.seabattle.exception.UnsupportedBoardFileFormatException;
import com.adach.piasecki.seabattle.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ManualBoardInitializeStrategy extends AbstractFileBoardInitializeStrategy {

    private static final String FILENAME = "manual.txt";

    private static final String SHIP_DESCRIPTION_FORMAT_ERROR_MESSAGE = "Wrong ship description format.";

    public Board initializeBoard() {
        int width;
        int height;
        List<Ship> shipList;
        AtomicInteger shipFieldsCount = new AtomicInteger();

        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            width = readWidth(scanner);
            height = readHeight(scanner);
            shipList = readShips(scanner);
        } catch (FileNotFoundException e) {
            throw new BoardFileNotFoundException(e);
        }

        final Map<Character, List<Field>> fieldMap = createFieldMap(width, height, shipList, shipFieldsCount);

        return new Board(width, height, fieldMap, shipList, shipFieldsCount.get());
    }

    private List<Ship> readShips(final Scanner scanner) {
        final List<Ship> shipList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() < 4) {
                throw new UnsupportedBoardFileFormatException(SHIP_DESCRIPTION_FORMAT_ERROR_MESSAGE);
            }
            char direction = line.charAt(0);
            if (direction == 'v') {
                char column = line.charAt(1);
                int beginRow = Character.getNumericValue(line.charAt(2));
                int endRow = Character.getNumericValue(line.charAt(3));
                shipList.add(new VerticalShip(column, beginRow, endRow));
            } else if (direction == 'h') {
                int row = Character.getNumericValue(line.charAt(1));
                char beginColumn = line.charAt(2);
                char endColumn = line.charAt(3);
                shipList.add(new HorizontalShip(row, beginColumn, endColumn));
            } else {
                throw new UnsupportedBoardFileFormatException(SHIP_DESCRIPTION_FORMAT_ERROR_MESSAGE);
            }
        }
        return shipList;
    }
}

package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.exception.UnsupportedBoardFileFormatException;

import java.util.Scanner;

abstract class AbstractFileBoardInitializeStrategy extends AbstractBoardInitializeStrategy {

    private static final String WIDTH_PARAMETER = "width";
    private static final String HEIGHT_PARAMETER = "height";
    private static final String WIDTH_NOT_PRESENT_ERROR_MESSAGE = "The width parameter is missing.";
    private static final String HEIGHT_NOT_PRESENT_ERROR_MESSAGE = "The height parameter is missing.";

    int readWidth(final Scanner scanner) {
        return readParameter(scanner, WIDTH_PARAMETER, WIDTH_NOT_PRESENT_ERROR_MESSAGE);
    }

    int readHeight(final Scanner scanner) {
        return readParameter(scanner, HEIGHT_PARAMETER, HEIGHT_NOT_PRESENT_ERROR_MESSAGE);
    }

    int readParameter(final Scanner scanner, final String parameter, final String parameterNotPresentErrorMessage) {
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            if (lineSplit.length < 2 || !lineSplit[0].equals(parameter)) {
                throw new UnsupportedBoardFileFormatException(parameterNotPresentErrorMessage);
            }
            return Integer.parseInt(lineSplit[1]);
        } else {
            throw new UnsupportedBoardFileFormatException(parameterNotPresentErrorMessage);
        }
    }
}

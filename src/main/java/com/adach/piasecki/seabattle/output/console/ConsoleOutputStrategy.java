package com.adach.piasecki.seabattle.output.console;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.FieldState;
import com.adach.piasecki.seabattle.output.OutputStrategy;

import java.util.Map;

import static com.adach.piasecki.seabattle.model.FieldState.*;
import static com.adach.piasecki.seabattle.output.console.AsciiCodes.A_ASCII_CODE;

public class ConsoleOutputStrategy implements OutputStrategy {

    private static final String BLANK_SPACE = " ";
    private static final Map<FieldState, String> FIELD_STATE_REPRESENTATION_MAP = Map.of(
            UNKNOWN, BLANK_SPACE,
            MISSED, "x",
            SCORED, "o"
    );

    @Override
    public void draw(final Board board) {
        clearScreen();

        final int boardWidth = board.getWidth();
        final int boardHeight = board.getHeight();

        print(BLANK_SPACE + BLANK_SPACE + BLANK_SPACE);
        for (int column = 0; column < boardWidth; column++) {
            print(asciiToString(column + A_ASCII_CODE));
            if (column != boardWidth - 1) {
                print(BLANK_SPACE);
            }
        }
        println();
        for (int row = 0; row < boardHeight; row++) {
            final int rowNumber = row + 1;
            print(Integer.toString(rowNumber));
            for (int i = 0; i + lengthOf(rowNumber) < 3; i++) {
                print(BLANK_SPACE);
            }
            for (int column = 0; column < boardWidth; column++) {
                print(FIELD_STATE_REPRESENTATION_MAP.get(board.getFieldStateAt(column, row)));
                if (column != boardWidth - 1) {
                    print(BLANK_SPACE);
                }
            }
            println();
        }
    }

    @Override
    public void displayMessage(final String message) {
        println();
        println(message);
        println();
    }

    private void clearScreen() {
        print("\033[H\033[2J");
        System.out.flush();
    }

    private void print(final String text) {
        System.out.print(text);
    }

    private void println(final String text) {
        System.out.println(text);
    }

    private void println() {
        println("");
    }

    private String asciiToString(final int code) {
        return Character.toString((char) code);
    }

    private int lengthOf(final int number) {
        return Integer.toString(number).length();
    }

}

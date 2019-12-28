package com.adach.piasecki.seabattle.output.console;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Coordinates;
import com.adach.piasecki.seabattle.model.FieldState;
import com.adach.piasecki.seabattle.output.OutputStrategy;

import java.util.Map;

public class ConsoleOutputStrategy implements OutputStrategy {

    private static final char START_COLUMN = 'A';
    private static final String BLANK_SPACE = " ";
    private static final Map<FieldState, String> FIELD_REPRESENTATIONS = Map.of(
        FieldState.UNKNOWN_EMPTY, BLANK_SPACE,
        FieldState.UNKNOWN_SHIP, BLANK_SPACE,
        FieldState.MISSED, "o",
        FieldState.HIT, "x",
        FieldState.SUNK, "*"
    );

    @Override
    public void drawBoard(final Board board) {
        clearScreen();
        printColumnLabels(board);
        printRows(board);
    }

    private void printColumnLabels(final Board board) {
        print(String.format("%-4s", BLANK_SPACE));

        for (int columnIndex = 0; columnIndex < board.getWidth(); columnIndex++) {
            char columnLabel = (char) (START_COLUMN + columnIndex);
            print(columnLabel + BLANK_SPACE);
        }
        println();
    }

    private void printRows(final Board board) {
        for (int row = 0; row < board.getHeight(); row++) {
            printRow(board, row);
        }
    }

    private void printRow(final Board board, final int row) {
        print(String.format("%-4s", row));

        for (int columnIndex = 0; columnIndex < board.getWidth(); columnIndex++) {
            char columnLabel = (char) (START_COLUMN + columnIndex);
            FieldState fieldState = board.getFieldStateAt(Coordinates.of(columnLabel, row));
            print(FIELD_REPRESENTATIONS.get(fieldState) + BLANK_SPACE);
        }
        println();
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

}

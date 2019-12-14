package com.adach.piasecki.seabattle.output.console;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Field.FieldState;
import com.adach.piasecki.seabattle.output.OutputStrategy;

import java.util.List;
import java.util.Map;

import static com.adach.piasecki.seabattle.model.Field.FieldState.*;

public class ConsoleOutputStrategy implements OutputStrategy {

    private static final String BLANK_SPACE = " ";
    private static final Map<FieldState, String> FIELD_STATE_REPRESENTATIONS = Map.of(
        UNKNOWN, BLANK_SPACE,
        MISSED, "x",
        SCORED, "o"
    );

    @Override
    public void drawBoard(final Board board) {
        List<Character> columnLabels = board.getColumnLabels();

        clearScreen();
        printColumnLabels(columnLabels);
        printRows(board, columnLabels);
    }

    private void printColumnLabels(List<Character> columnLabels) {
        print(String.format("%-3s", BLANK_SPACE));
        columnLabels.forEach(columnLabel -> {
            print(Character.toUpperCase(columnLabel) + BLANK_SPACE);
        });
        println();
    }

    private void printRows(Board board, List<Character> columnLabels) {
        for (int row = 0; row < board.getHeight(); row++) {
            printRowLabel(row);
            for (char columnLabel : columnLabels) {
                FieldState fieldState = board.getFieldAt(columnLabel, row).getState();
                print(FIELD_STATE_REPRESENTATIONS.get(fieldState) + BLANK_SPACE);
            }
            println();
        }
    }

    private void printRowLabel(int row) {
        final int rowNumber = row + 1;
        print(String.format("%-3s", rowNumber));
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

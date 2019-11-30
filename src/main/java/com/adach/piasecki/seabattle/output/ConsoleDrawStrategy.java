package com.adach.piasecki.seabattle.output;

import com.adach.piasecki.seabattle.model.Board;

public class ConsoleDrawStrategy implements DrawStrategy {

    private int i = 0;

    private static final int A_ASCII_CODE = 65;

    @Override
    public void draw(Board board) {
        clearScreen();
        println("test " + i);
        i++;

        final int boardWidth = board.getWidth();
        final int boardHeight = board.getHeight();

        print("  ");
        for (int column = 0; column < boardWidth; column++) {
            print(asciiToString(column + A_ASCII_CODE));
            if (column != boardWidth - 1) {
                print(" ");
            }
        }
        println("");
        for (int row = 0; row < boardHeight; row++) {
            print(Integer.toString(row + 1) + " ");
            for (int column = 0; column < boardWidth; column++) {
                print("x");
                if (column != boardWidth - 1) {
                    print(" ");
                }
            }
            println("");
        }
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

    private String asciiToString(final int code) {
        return Character.toString((char) code);
    }

}

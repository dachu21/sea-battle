package com.adach.piasecki.seabattle.output;

import com.adach.piasecki.seabattle.model.Board;

public class ConsoleDrawStrategy implements DrawStrategy {

    private int i = 0;

    @Override
    public void draw(Board board) {
        clearScreen();
        System.out.print("test " + i);
        i++;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

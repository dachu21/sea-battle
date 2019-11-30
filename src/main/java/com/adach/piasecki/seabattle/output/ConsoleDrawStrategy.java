package com.adach.piasecki.seabattle.output;

import com.adach.piasecki.seabattle.model.Board;

import java.io.IOException;

public class ConsoleDrawStrategy implements DrawStrategy {

    @Override
    public void draw(Board board) {
        System.out.print("test");
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

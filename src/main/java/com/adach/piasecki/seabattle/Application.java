package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.initializer.PropertiesBoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.ConsoleInputStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.output.ConsoleDrawStrategy;
import com.adach.piasecki.seabattle.output.DrawStrategy;

public class Application {

    public static void main(String[] args) {
        final DrawStrategy drawStrategy = new ConsoleDrawStrategy();
        final InputStrategy inputStrategy = new ConsoleInputStrategy();
        final BoardInitializeStrategy boardInitializeStrategy = new PropertiesBoardInitializeStrategy();
        final Game game = new Game(inputStrategy, drawStrategy, boardInitializeStrategy);
        game.start();
    }
}

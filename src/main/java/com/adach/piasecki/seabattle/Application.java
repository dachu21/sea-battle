package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.initializer.PropertiesBoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.ConsoleInputStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.output.ConsoleOutputStrategy;
import com.adach.piasecki.seabattle.output.OutputStrategy;

public class Application {

    public static void main(final String[] args) {
        final OutputStrategy outputStrategy = new ConsoleOutputStrategy();
        final InputStrategy inputStrategy = new ConsoleInputStrategy();
        final BoardInitializeStrategy boardInitializeStrategy = new PropertiesBoardInitializeStrategy();
        final Game game = new Game(inputStrategy, outputStrategy, boardInitializeStrategy);
        game.run();
        inputStrategy.dispose();
    }
}

package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.initializer.PropertiesBoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.input.console.ConsoleInputStrategy;
import com.adach.piasecki.seabattle.output.OutputStrategy;
import com.adach.piasecki.seabattle.output.console.ConsoleOutputStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static void main(final String[] args) {
        final BoardInitializeStrategy boardInitializeStrategy = new PropertiesBoardInitializeStrategy();
        final OutputStrategy outputStrategy = new ConsoleOutputStrategy();
        try (final InputStrategy inputStrategy = new ConsoleInputStrategy()) {
            new Game(inputStrategy, outputStrategy, boardInitializeStrategy).run();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

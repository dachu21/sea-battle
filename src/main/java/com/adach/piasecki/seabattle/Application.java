package com.adach.piasecki.seabattle;

import com.adach.piasecki.seabattle.exception.InvalidCommandLineArgumentException;
import com.adach.piasecki.seabattle.game.Game;
import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.initializer.ManualBoardInitializeStrategy;
import com.adach.piasecki.seabattle.initializer.RandomBoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.input.console.ConsoleInputStrategy;
import com.adach.piasecki.seabattle.output.OutputStrategy;
import com.adach.piasecki.seabattle.output.console.ConsoleOutputStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static void main(final String[] args) {
        try (final InputStrategy inputStrategy = new ConsoleInputStrategy()) {
            final BoardInitializeStrategy boardInitializeStrategy =
                chooseBoardInitializeStrategy(parseBoardInitializeStrategyArg(args));
            final OutputStrategy outputStrategy = new ConsoleOutputStrategy();
            new Game(inputStrategy, outputStrategy, boardInitializeStrategy).run();
        } catch (Exception ex) {
            log.error("An error occurred while running application:", ex);
        }
    }

    private static String parseBoardInitializeStrategyArg(final String[] args) throws InvalidCommandLineArgumentException {
        if (args.length != 1) {
            throw new InvalidCommandLineArgumentException("Command line argument for board initialize strategy is missing!");
        }
        return args[0];
    }

    private static BoardInitializeStrategy chooseBoardInitializeStrategy(String arg) throws InvalidCommandLineArgumentException {
        switch (arg) {
            case "-m":
                return new ManualBoardInitializeStrategy();
            case "-r":
                return new RandomBoardInitializeStrategy();
            default:
                throw new InvalidCommandLineArgumentException("Command line argument for board initialize strategy should be '-m' or '-r'!");
        }
    }
}

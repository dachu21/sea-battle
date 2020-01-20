package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.exception.InvalidCommandException;
import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandValidator;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.OutputStrategy;

class GameEngine {

    private final Board board;
    private final InputStrategy inputStrategy;
    private final OutputStrategy outputStrategy;
    private final CommandValidator commandValidator;
    private final GameLogicProcessor logicProcessor;

    GameEngine(Board board, InputStrategy inputStrategy, OutputStrategy outputStrategy) {
        this.board = board;
        this.inputStrategy = inputStrategy;
        this.outputStrategy = outputStrategy;
        this.commandValidator = new CommandValidator(board.getWidth(), board.getHeight());
        this.logicProcessor = new GameLogicProcessor();
    }

    boolean run() {
        GameStatus gameStatus = initializeGameStatus();
        displayBoard(board);

        while (gameStatus.getHitsLeft() > 0) {
            try {
                final Command command = inputStrategy.waitForInput();
                commandValidator.validate(command);
                gameStatus = updateGameStatus(gameStatus, command);
            } catch (InvalidInputException | InvalidCommandException ex) {
                displayInvalidCommandError();
            }
            displayBoard(board);
        }

        displayWinMessage(gameStatus);
        return true;
    }

    private GameStatus initializeGameStatus() {
        return new GameStatus(board.getShipFieldsCount(), 0);
    }

    private GameStatus updateGameStatus(final GameStatus currentGameStatus, final Command command) {
        return logicProcessor.processCommand(board, currentGameStatus, command);
    }

    private void displayBoard(final Board board) {
        outputStrategy.drawBoard(board);
    }

    private void displayInvalidCommandError() {
        outputStrategy.displayMessage("Invalid command! Did you miss the board?");
    }

    private void displayWinMessage(final GameStatus gameStatus) {
        outputStrategy.displayMessage("You won! Total moves: " + gameStatus.getTotalMoves());
    }
}

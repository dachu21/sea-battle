package com.adach.piasecki.seabattle.input.console;

import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.input.Command;
import com.adach.piasecki.seabattle.input.CommandProcessor;
import com.adach.piasecki.seabattle.input.InputStrategy;

import java.util.Scanner;

public class ConsoleInputStrategy implements InputStrategy {

    private final Scanner scanner = new Scanner(System.in);
    private final CommandProcessor commandProcessor = new StringCommandProcessor();

    @Override
    public Command waitForInput() throws InvalidInputException {
        String input;
        do {
            input = scanner.nextLine();
        } while (input.isBlank());
        return commandProcessor.processCommand(input);
    }

    @Override
    public void close() {
        scanner.close();
    }
}

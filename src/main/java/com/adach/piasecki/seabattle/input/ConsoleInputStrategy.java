package com.adach.piasecki.seabattle.input;

import java.util.Scanner;

public class ConsoleInputStrategy implements InputStrategy {

    private final Scanner scanner;
    private final CommandProcessor commandProcessor;

    public ConsoleInputStrategy() {
        scanner = new Scanner(System.in);
        commandProcessor = new StringCommandProcessor();
    }

    @Override
    public Command waitForInput() {
        String input = null;
        while (isEmpty(input)) {
            input = scanner.nextLine();
        }
        return commandProcessor.processCommand(input);
    }

    @Override
    public void dispose() {
        scanner.close();
    }

    private boolean isEmpty(final String string) {
        return string == null || string.trim().isEmpty();
    }
}

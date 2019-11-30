package com.adach.piasecki.seabattle.input;

public class ConsoleInputStrategy implements InputStrategy {

    @Override
    public Command waitForInput() {
        //while(true)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

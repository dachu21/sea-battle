package com.adach.piasecki.seabattle.input;

public interface InputStrategy {

    Command waitForInput();

    void dispose();
}

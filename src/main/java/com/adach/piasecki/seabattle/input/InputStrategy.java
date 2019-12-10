package com.adach.piasecki.seabattle.input;

public interface InputStrategy extends AutoCloseable {

    Command waitForInput();
}

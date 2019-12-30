package com.adach.piasecki.seabattle.input;

import com.adach.piasecki.seabattle.exception.InvalidInputException;

public interface InputStrategy extends AutoCloseable {

    Command waitForInput() throws InvalidInputException;
}

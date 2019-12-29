package com.adach.piasecki.seabattle.exception;

public class BoardFileNotFoundException extends RuntimeException {

    public BoardFileNotFoundException(Exception exception) {
        super(exception);
    }
}

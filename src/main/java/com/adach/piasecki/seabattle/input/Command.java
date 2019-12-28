package com.adach.piasecki.seabattle.input;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Command {

    private final char column;
    private final int row;
}

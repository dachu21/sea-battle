package com.adach.piasecki.seabattle.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class GameStatus {

    private final long hitsLeft;
    private final long totalMoves;
}

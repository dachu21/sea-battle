package com.adach.piasecki.seabattle.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameStatusTest {

    @Test
    void shouldConstructValidGameStatus() {
        GameStatus gameStatus = new GameStatus(5, 10);
        Assertions.assertEquals(5, gameStatus.getHitsLeft());
        Assertions.assertEquals(10, gameStatus.getTotalMoves());
    }
}

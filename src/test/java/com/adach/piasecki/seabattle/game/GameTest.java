package com.adach.piasecki.seabattle.game;

import com.adach.piasecki.seabattle.exception.InvalidInputException;
import com.adach.piasecki.seabattle.initializer.BoardInitializeStrategy;
import com.adach.piasecki.seabattle.input.InputStrategy;
import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.output.OutputStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameTest {

    private Game game;

    @BeforeEach
    void setUp() throws InvalidInputException {
        InputStrategy inputStrategy = mock(InputStrategy.class);
        OutputStrategy outputStrategy = mock(OutputStrategy.class);
        BoardInitializeStrategy boardInitializeStrategy = mock(BoardInitializeStrategy.class);

        doReturn(true)
            .when(outputStrategy).displayMessage(any());
        doReturn(true)
            .when(outputStrategy).drawBoard(any());
        doReturn(new Board(0, 0, 0, Collections.emptyList(), Collections.emptyMap()))
            .when(boardInitializeStrategy).initializeBoard();

        game = new Game(inputStrategy, outputStrategy, boardInitializeStrategy);
    }

    @Test
    void shouldSuccessfullyFinishRun() {
        assertTrue(game.run());
    }
}

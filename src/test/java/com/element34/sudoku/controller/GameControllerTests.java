package com.element34.sudoku.controller;

import com.element34.sudoku.entity.Game;
import com.element34.sudoku.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GameControllerTests.class)
public class GameControllerTests {
    @MockBean
    private GameService gameService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void gameById() throws Exception {
        Game game = new Game();
        game.setId(1l);
        game.setGameDetails("[0,2,0,4],[0,0,0,0],[0,0,0,0],[2,0,1,0]");
        game.setGameSolution("[1,2,2,4],[4,2,2,1],[2,1,4,2],[2,4,1,2]");
        game.setGameComplexity("EASY");

        when(gameService.getGameById("1")).thenReturn(Optional.of(game));
        mockMvc.perform(get("/game/{id}", 1)).andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.gameDetails").value(game.getGameDetails()))
            .andExpect(jsonPath("$.gameSolution").value(game.getGameSolution()))
            .andExpect(jsonPath("$.gameComplexity").value(game.getGameComplexity()))
            .andDo(print());
    }
}
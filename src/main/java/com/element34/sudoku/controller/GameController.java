package com.element34.sudoku.controller;

import com.element34.sudoku.entity.Game;
import com.element34.sudoku.entity.PlayerGame;
import com.element34.sudoku.service.GameService;
import com.element34.sudoku.service.PlayerGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerGameService playerGameService;

    @GetMapping("/{id}")
    public Optional<Game> getGameById(@PathVariable("id") String gameId) {
        return gameService.getGameById(gameId);
    }

    @GetMapping("/{gameId}/player/{playerId}/solve")
    public Optional<String> getPlayGame(@PathVariable("gameId") String gameId,
                                        @PathVariable("playerId") String playerId) {

        return gameService.getPlayGame(gameId);
    }

    @PostMapping("/{gameId}/player/{playerId}/solution")
    public PlayerGame solvePlayGame(@PathVariable("gameId") String gameId,
                                              @PathVariable("playerId") String playerId,
                                              @RequestBody PlayerGame playerGame) {

        return playerGameService.save(gameId, playerId, playerGame);
    }
}
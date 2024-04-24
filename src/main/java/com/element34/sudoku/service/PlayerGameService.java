package com.element34.sudoku.service;

import com.element34.sudoku.entity.PlayerGame;
import com.element34.sudoku.repository.GameRepository;
import com.element34.sudoku.repository.PlayerGameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PlayerGameService {
    @Autowired
    private PlayerGameRepository playerGameRepository;
    @Autowired
    private GameRepository gameRepository;

    public PlayerGame save(String gameId, String playerId, PlayerGame playerGame) {
        playerGame.setPlayerId(Long.valueOf(playerId));
        playerGame.setGameId(Long.valueOf(gameId));
        playerGame.setSolve(isValid(gameId, playerGame.getGameDetails()));

        return playerGameRepository.save(playerGame);
    }

    //Sudoku player input solution validation (server side)
    private Boolean isValid(String gameId, String gameDetails) {
        Optional<String> solution = gameRepository.getGameSolution(Long.valueOf(gameId));

        return solution.get().equals(gameDetails);
    }
}
package com.element34.sudoku.service;

import com.element34.sudoku.entity.Game;
import com.element34.sudoku.exception.GameException;
import com.element34.sudoku.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public void saveAll(List<Game> masterGameList) {
        gameRepository.saveAll(masterGameList);
    }

    public Optional<Game> getGameById(String gameId) {
        return Optional.ofNullable(gameRepository.findById(Long.valueOf(gameId)).orElseThrow(()
                -> new GameException(String.format("No Game found for game id %s", gameId))));
    }

    public Optional<String> getPlayGame(String gameId) {
        return Optional.ofNullable(gameRepository.getPlayGame(Long.valueOf(gameId))
                .orElseThrow(() -> new GameException(String.format("No Game found for game id %s", gameId))));
    }
}
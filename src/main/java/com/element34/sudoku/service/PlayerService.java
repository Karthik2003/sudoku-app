package com.element34.sudoku.service;

import com.element34.sudoku.entity.Player;
import com.element34.sudoku.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    public void saveAll(List<Player> playerList) {
        playerRepository.saveAll(playerList);
    }

}
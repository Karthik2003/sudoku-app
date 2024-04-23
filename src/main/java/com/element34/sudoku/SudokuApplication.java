package com.element34.sudoku;

import com.element34.sudoku.entity.Game;
import com.element34.sudoku.entity.Player;
import com.element34.sudoku.service.GameService;
import com.element34.sudoku.service.PlayerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SudokuApplication {

	public static void main(String[] args) {

		SpringApplication.run(SudokuApplication.class, args);
		log.info(".......... sudoku-app started...........");
	}
	@Bean
	CommandLineRunner commandLineRunner(GameService gameService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Game>> typeReference = new TypeReference<List<Game>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/game_data.json");
			try {
				List<Game> gameList = mapper.readValue(inputStream,typeReference);
				gameService.saveAll(gameList);
				log.info("....... master game data persisted ...........");
			} catch (Exception e){
				log.error("...... master game data persist failed ......");
				throw new IOException(e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner commandLineUserRunner(PlayerService playerService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Player>> typeReference = new TypeReference<List<Player>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/player_data.json");
			try {
				List<Player> playerList = mapper.readValue(inputStream,typeReference);
				playerService.saveAll(playerList);
				log.info(".......  player data persisted ...........");
			} catch (Exception e){
				log.error("......  player data persist failed ......");
				throw new IOException(e.getMessage());
			}
		};
	}
}
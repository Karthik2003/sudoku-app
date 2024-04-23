package com.element34.sudoku.repository;

import com.element34.sudoku.entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    @Query(value = "SELECT GAME_DETAILS FROM GAME WHERE ID = :gameId ", nativeQuery = true)
    Optional<String> getPlayGame(@Param("gameId") final Long gameId);

    @Query(value = "SELECT GAME_SOLUTION FROM GAME WHERE ID = :gameId ", nativeQuery = true)
    Optional<String> getGameSolution(@Param("gameId") final Long gameId);
}
package com.element34.sudoku.repository;

import com.element34.sudoku.entity.PlayerGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerGameRepository extends CrudRepository<PlayerGame, Long> {

}
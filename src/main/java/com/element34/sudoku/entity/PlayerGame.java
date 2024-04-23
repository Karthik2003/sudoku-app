package com.element34.sudoku.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class PlayerGame implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "player.ssn")
    private Long playerId;
    @JoinColumn(name = "game.id")
    private Long gameId;
    private String gameDetails;
    private Boolean solve;
}
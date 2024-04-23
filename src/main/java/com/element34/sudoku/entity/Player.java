package com.element34.sudoku.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Player implements Serializable {
    @Id
    private Long ssn;
    private String name;
}
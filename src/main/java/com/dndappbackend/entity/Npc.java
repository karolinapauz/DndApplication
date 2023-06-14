package com.dndappbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Npc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;

    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer charisma;
    private Integer wisdom;

    private Integer acrobatics;
    private Integer animalHandling;
    private Integer arcana;
    private Integer athletics;
    private Integer deception;
    private Integer history;
    private Integer insight;
    private Integer intimidation;
    private Integer investigation;
    private Integer medicine;
    private Integer nature;
    private Integer perception;
    private Integer performance;
    private Integer persuasion;
    private Integer religion;
    private Integer sleightOfHand;
    private Integer stealth;
    private Integer survival;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Npc(String name) {
        this.name = name;
    }
}

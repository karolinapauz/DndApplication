package com.dndappbackend.entity;

import com.dndappbackend.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlayableChar {

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
    private Integer gold;
    private Integer silver;
    private Integer copper;
    private Integer platinum;

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
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "playableChar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public PlayableChar(String name) {
        this.name = name;
    }
}

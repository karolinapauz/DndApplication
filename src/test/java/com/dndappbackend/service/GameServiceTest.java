package com.dndappbackend.service;

import com.dndappbackend.entity.Game;
import com.dndappbackend.entity.Location;
import com.dndappbackend.entity.Npc;
import com.dndappbackend.entity.PlayableChar;
import com.dndappbackend.entity.user.User;
import com.dndappbackend.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllGames() {
        List<User> users = new ArrayList<>();
        users.add(new User(null, "tomas", null, null, null, null, null, null, null));
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(null, "river", null, null, null));
        List<PlayableChar> playableChars = new ArrayList<>();
        playableChars.add(new PlayableChar("elf"));
        List<Npc> npcs = new ArrayList<>();
        npcs.add(new Npc("tod"));
        Game game1 = new Game(1L, "game1", users, playableChars, locations, npcs);

        List<User> users2 = new ArrayList<>();
        users2.add(new User(null, "marija", null, null, null, null, null, null, null));
        List<Location> locations2 = new ArrayList<>();
        locations2.add(new Location(null, "mountain", null, null, null));
        List<PlayableChar> playableChars2 = new ArrayList<>();
        playableChars2.add(new PlayableChar("frog"));
        List<Npc> npcs2 = new ArrayList<>();
        npcs2.add(new Npc("horse"));
        Game game2 = new Game(1L, "game2", users2, playableChars2, locations2, npcs2);

        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = gameService.getAllGames();

        assertEquals(2, result.size());
        assertEquals("game2", result.get(1).getName());
    }

    @Test
    void addGame() {
    }
}
package com.dndappbackend.service;

import com.dndappbackend.dto.GameDto;
import com.dndappbackend.dto.UserDto;
import com.dndappbackend.entity.Game;
import com.dndappbackend.entity.user.User;
import com.dndappbackend.repository.GameRepository;
import com.dndappbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public List<Game> getAllGames(){
        log.info("All games for ADMIN");
        return gameRepository.findAll();
    }

    public List<Game> addGame(GameDto gameDto) {
        Game game = new Game();
        game.setName(gameDto.getName());
        gameRepository.save(game);
        log.info("New game " + gameDto + " was added.");
        return gameRepository.findAll();
    }



}

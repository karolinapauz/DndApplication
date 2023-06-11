package com.dndappbackend.controller;

import com.dndappbackend.dto.GameDto;
import com.dndappbackend.entity.Game;
import com.dndappbackend.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/game")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/admin")
    @CrossOrigin
    public List<Game> findAllGames(){
        return gameService.getAllGames();
    }

    @PostMapping("/admin/add")
    @CrossOrigin
    public List<Game> addGame(@RequestBody GameDto gameDto){
        return gameService.addGame(gameDto);
    }


}

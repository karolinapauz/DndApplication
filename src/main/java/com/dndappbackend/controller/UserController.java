package com.dndappbackend.controller;

import com.dndappbackend.dto.UserDto;
import com.dndappbackend.entity.Game;
import com.dndappbackend.entity.user.User;
import com.dndappbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:63997")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
       return userService.loginUser(user);
    }

    @GetMapping("/admin/all")
    @CrossOrigin
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    /**
     * Method user only for admin
     * @param id specific user id
     * @return list of games that belongs to specific user
     */
    @GetMapping("/admin/{id}")
    @CrossOrigin
    public List<Game> showUserGames(@PathVariable Long id) {
        return userService.showGamesById(id);
    }

    @GetMapping("/userinfo")
    @CrossOrigin
    public User getLoggedInUser() {
        return userService.getLoggedInUser();
    }

    @PostMapping("/admin/add")
    @CrossOrigin
    public List<User> addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }
}

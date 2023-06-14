package com.dndappbackend.service;

import com.dndappbackend.dto.UserDto;
import com.dndappbackend.entity.Game;
import com.dndappbackend.entity.user.User;
import com.dndappbackend.repository.GameRepository;
import com.dndappbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<?> loginUser(User userData) {
        User user = userRepository.findByFirstname(userData.getFirstname());
        if (user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public List<Game> showGamesById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get().getGames();
        }
        return Collections.emptyList(); // Return an empty list if the user with the given ID is not found
    }

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return userRepository.findByFirstname(username);
    }
    public List<User> addUser(UserDto userDto){
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setEnabled(userDto.getEnabled());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        userRepository.save(user);
        log.info("New user " + userDto + " was added.");
        return userRepository.findAll();
    }

//    public List<Game> getLoggedInUserGames() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String username = userDetails.getUsername();
//        User user = userRepository.findByFirstname(username);
//        return user.getGames();
//    }

}

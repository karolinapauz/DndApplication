package com.dndappbackend.config;

import com.dndappbackend.entity.*;
import com.dndappbackend.entity.user.Roles;
import com.dndappbackend.entity.user.User;
import com.dndappbackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, GameRepository gameRepository, CharRepository charRepository, LocationRepository locationRepository, NpcRepository npcRepository, ItemRepository itemRepository) {
        return args -> {

            Game game1 = Game.builder()
                    .name("Magical Journey")
                    .build();

            Game game2 = Game.builder()
                    .name("Scary dungeons")
                    .build();

            User mantas = User.builder()
                    .email("mantas@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("mantas"))
                    .firstname("mantas")
                    .lastname("mantas")
                    .enabled(true)
                    .roles(Set.of(new Role(Roles.ADMIN)))
                    .games(Arrays.asList(game1))
                    .build();

            User tomas = User.builder()
                    .email("tomas@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("tomas"))
                    .firstname("tomas")
                    .lastname("tomas")
                    .enabled(true)
                    .roles(Set.of(new Role(Roles.USER)))
                    .games(Arrays.asList(game1))
                    .build();

            User monika = User.builder()
                    .email("monika@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("monika"))
                    .firstname("monika")
                    .lastname("monika")
                    .enabled(true)
                    .roles(Set.of(new Role(Roles.USER)))
                    .games(Arrays.asList(game2))
                    .build();

            PlayableChar elf = PlayableChar.builder()
                    .name("Elf")
                    .user(mantas)
                    .game(game1)
                    .build();

            PlayableChar druid = PlayableChar.builder()
                    .name("Druid")
                    .user(tomas)
                    .game(game1)
                    .build();

            PlayableChar human = PlayableChar.builder()
                    .name("Human")
                    .user(monika)
                    .game(game2)
                    .build();

            Location river = Location.builder()
                    .name("River")
                    .description("Deep river, by the spooky mountains.")
                    .game(game1)
                    .build();

            Location castle = Location.builder()
                    .name("Knight's castle")
                    .description("Center of the kingdom")
                    .game(game1)
                    .build();

            Location mountain = Location.builder()
                    .name("Spooky mountain")
                    .description("Highest mountain in the kingdom")
                    .game(game2)
                    .build();

            Location tavern = Location.builder()
                    .name("Tavern")
                    .description("Popular place to drink beer")
                    .game(game2)
                    .build();

            Npc cat = Npc.builder()
                    .name("Cat")
                    .description("Cute kitty with sharp nails")
                    .game(game1)
                    .build();

            Npc dog = Npc.builder()
                    .name("Dog")
                    .description("Always angry at strangers")
                    .game(game2)
                    .build();

            Item knife = Item.builder()
                    .name("Knife")
                    .description("sharp")
                    .playableChar(human)
                    .build();

            Item dagger = Item.builder()
                    .name("Dagger")
                    .description("sharp")
                    .playableChar(druid)
                    .build();

            Item bow = Item.builder()
                    .name("Bow")
                    .description("light")
                    .playableChar(elf)
                    .build();

            Item axe = Item.builder()
                    .name("Axe")
                    .description("heavy")
                    .playableChar(druid)
                    .build();

            gameRepository.save(game1);
            gameRepository.save(game2);
            userRepository.save(mantas);
            userRepository.save(tomas);
            userRepository.save(monika);
            charRepository.save(elf);
            charRepository.save(druid);
            charRepository.save(human);
            locationRepository.save(river);
            locationRepository.save(castle);
            locationRepository.save(mountain);
            locationRepository.save(tavern);
            npcRepository.save(cat);
            npcRepository.save(dog);
            itemRepository.save(knife);
            itemRepository.save(dagger);
            itemRepository.save(bow);
            itemRepository.save(axe);


        };
    }
}


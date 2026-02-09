package com.example.boardgame.controller;

import com.example.boardgame.model.Game;
import com.example.boardgame.repository.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameRepository gameRepository;

    // Wstrzykujemy repozytorium przez konstruktor
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // PRZYKŁAD: Pobieranie wszystkich gier
    // Adres: GET http://localhost:8080/api/games
    @GetMapping
    public Iterable<Game> getAll() {
        return gameRepository.findAll();
    }

    // PRZYKŁAD: Wyszukiwanie po kategorii
    // Adres: GET http://localhost:8080/api/games/category/Strategia
    @GetMapping("/category/{cat}")
    public List<Game> getByCategory(@PathVariable String cat) {
        return gameRepository.findByCategory(cat);
    }

    // PRZYKŁAD: Dodawanie nowej gry przez API
    // Adres: POST http://localhost:8080/api/games
    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }
}

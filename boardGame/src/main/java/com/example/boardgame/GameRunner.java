package com.example.boardgame;

import com.example.boardgame.model.Game;
import com.example.boardgame.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRunner implements CommandLineRunner {
    private final GameRepository gameRepository;

    public GameRunner(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // PRZYKŁAD 1: Dodawanie rekordów do Postgresa
        System.out.println("--- ZAPISYWANIE DANYCH ---");
        gameRepository.save(new Game("Catan", "Strategia", 15.0));
        gameRepository.save(new Game("Dixit", "Imprezowa", 10.0));
        gameRepository.save(new Game("Terraformacja Marsa", "Strategia", 25.0));

        // PRZYKŁAD 2: Wyciąganie wszystkiego (findAll)
        System.out.println("--- LISTA WSZYSTKICH GIER ---");
        gameRepository.findAll().forEach(game -> {
            System.out.println("ID: " + game.getId() + " | Tytuł: " + game.getTitle());
        });

        // PRZYKŁAD 3: Użycie Twojej własnej metody findByCategory
        System.out.println("--- GRY STRATEGICZNE ---");
        List<Game> strategie = gameRepository.findByCategory("Strategia");
        for (Game g : strategie) {
            System.out.println("- " + g.getTitle() + " (Cena: " + g.getRentPrice() + ")");
        }

        // PRZYKŁAD 4: Wyszukiwanie tekstu (ContainingIgnoreCase)
        System.out.println("--- WYSZUKIWANIE 'mars' ---");
        gameRepository.findByTitleContainingIgnoreCase("mars")
                .forEach(g -> System.out.println("Znaleziono: " + g.getTitle()));
    }
}

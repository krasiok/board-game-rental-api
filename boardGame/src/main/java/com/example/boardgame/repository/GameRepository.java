package com.example.boardgame.repository;

import com.example.boardgame.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findByCategory(String category);
    List<Game> findByIsAvailableTrue();
    List<Game> findByTitleContainingIgnoreCase(String title);
}

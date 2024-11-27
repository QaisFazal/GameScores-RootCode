package com.demo.gamescores_rootcode.service.Implementation;

import com.demo.gamescores_rootcode.Repository.GameRepository;
import com.demo.gamescores_rootcode.model.Game;
import com.demo.gamescores_rootcode.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    GameRepository gameRepository;


    @Override
    public Game createGameRecord(Game game) {
        if(game.getName() == null || game.getName().isEmpty()) {
            throw new IllegalArgumentException("Game should have a name.");
        }

        gameRepository.findByName(game.getName()).ifPresent(e -> {
            throw new IllegalArgumentException("Game already exists.");
        });

        return gameRepository.save(game);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}

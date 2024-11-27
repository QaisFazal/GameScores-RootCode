package com.demo.gamescores_rootcode.service;

import com.demo.gamescores_rootcode.model.Game;

import java.util.List;

public interface GameService {
    Game createGameRecord(Game game);
    List<Game> getAllGames();
}

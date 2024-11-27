package com.demo.gamescores_rootcode.service;

import com.demo.gamescores_rootcode.model.Score;
import com.demo.gamescores_rootcode.payload.UserHighScore;

import java.util.List;

public interface ScoreService {
    Score insertUserScore(Long userId, Long gameId, Score scores);
    List<UserHighScore> getUserHighScore(Long userId);
    List<UserHighScore> getUserTopScorersPerGame(Long gameId);

}

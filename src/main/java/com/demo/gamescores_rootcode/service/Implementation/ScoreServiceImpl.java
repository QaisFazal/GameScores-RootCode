package com.demo.gamescores_rootcode.service.Implementation;

import com.demo.gamescores_rootcode.Repository.GameRepository;
import com.demo.gamescores_rootcode.Repository.ScoreRepository;
import com.demo.gamescores_rootcode.Repository.UserRepository;
import com.demo.gamescores_rootcode.model.Game;
import com.demo.gamescores_rootcode.model.Score;
import com.demo.gamescores_rootcode.model.User;
import com.demo.gamescores_rootcode.payload.UserHighScore;
import com.demo.gamescores_rootcode.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public Score insertUserScore(Long userId, Long gameId, Score score) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));

        score.setGame(game);
        score.setUser(user);

        return scoreRepository.save(score);
    }

    @Override
    public List<UserHighScore> getUserHighScore(Long userId) {
        return scoreRepository.getUserHighScores(userId);

    }

    @Override
    public List<UserHighScore> getUserTopScorersPerGame(Long gameId) {
        return scoreRepository.getUserTopScorersPerGame(gameId);
    }
}

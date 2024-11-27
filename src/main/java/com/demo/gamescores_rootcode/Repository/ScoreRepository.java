package com.demo.gamescores_rootcode.Repository;

import com.demo.gamescores_rootcode.model.Game;
import com.demo.gamescores_rootcode.model.Score;
import com.demo.gamescores_rootcode.payload.GameScore;
import com.demo.gamescores_rootcode.payload.UserHighScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query("SELECT new com.demo.gamescores_rootcode.payload.UserHighScore(u.username, g.name, MAX(score)) FROM Score s JOIN s.user u JOIN s.game g WHERE u.id = :userId GROUP BY u.id")
    List<UserHighScore> getUserHighScores(@Param("userId") Long userId);

    @Query("SELECT new com.demo.gamescores_rootcode.payload.UserHighScore(u.username, g.name, MAX(s.score) as max) FROM Score s JOIN s.user u JOIN s.game g WHERE g.id = :gameId GROUP BY u.id ORDER BY max DESC LIMIT 10")
    List<UserHighScore> getUserTopScorersPerGame(@Param("gameId") Long gameId);
}

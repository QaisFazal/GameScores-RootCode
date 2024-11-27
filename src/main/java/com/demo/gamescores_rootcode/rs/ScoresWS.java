package com.demo.gamescores_rootcode.rs;

import com.demo.gamescores_rootcode.model.Score;
import com.demo.gamescores_rootcode.payload.ErrorResponse;
import com.demo.gamescores_rootcode.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/scores")
public class ScoresWS {
    @Autowired
    ScoreService scoreService;

    @PostMapping
    public ResponseEntity<?> addScore(@RequestParam Long userId, @RequestParam Long gameId, @RequestBody Score score) {
        try {
            Score createdScore = scoreService.insertUserScore(userId, gameId, score);

            return ResponseEntity.ok(createdScore);
        } catch (IllegalArgumentException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    @GetMapping
    public ResponseEntity<?> getHighScorePerUser(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(scoreService.getUserHighScore(userId));
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    @GetMapping("/topScorers")
    public ResponseEntity<?> getTopScorers(@RequestParam Long gameId) {
        try {
            return ResponseEntity.ok(scoreService.getUserTopScorersPerGame(gameId));
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

}

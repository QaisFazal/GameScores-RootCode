package com.demo.gamescores_rootcode.payload;

import java.util.List;

public class GameScore {
    private String game;
    private List<UserHighScore> userHighScores;

    public GameScore(String game, List<UserHighScore> highScore) {
        this.game = game;
        this.userHighScores = highScore;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public List<UserHighScore> getUserHighScores() {
        return userHighScores;
    }

    public void setUserHighScores(List<UserHighScore> userHighScores) {
        this.userHighScores = userHighScores;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "game='" + game + '\'' +
                ", userHighScores=" + userHighScores +
                '}';
    }
}

package com.demo.gamescores_rootcode.payload;

public class UserHighScore {
    private String username;
    private String game;
    private int highScore;

    public UserHighScore(String username, String game, int highScore) {
        this.username = username;
        this.game = game;
        this.highScore = highScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}

package com.pjatk.quizmo.fragments;

public class QuizResult {
    private String playerName;
    private int score;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public QuizResult(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    // Add getters and setters for playerName and score
}

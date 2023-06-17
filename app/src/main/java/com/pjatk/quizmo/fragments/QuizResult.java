package com.pjatk.quizmo.fragments;

public class QuizResult {
    private String playerName;
    private int score;

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public QuizResult(String playerName, int score) {
        // Initialize a new QuizResult object with the given player name and score
        this.playerName = playerName;
        this.score = score;
    }
}

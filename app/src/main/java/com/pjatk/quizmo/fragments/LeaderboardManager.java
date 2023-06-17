package com.pjatk.quizmo.fragments;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardManager {
    private List<QuizResult> leaderboardData;

    public LeaderboardManager() {
        // Initialize an empty leaderboard data list
        leaderboardData = new ArrayList<>();
    }

    public void addQuizResult(QuizResult quizResult) {
        // Add a quiz result to the leaderboard data list
        leaderboardData.add(quizResult);
    }
}

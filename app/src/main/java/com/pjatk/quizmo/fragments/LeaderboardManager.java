package com.pjatk.quizmo.fragments;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardManager {
    private List<QuizResult> leaderboardData;

    public LeaderboardManager() {
        leaderboardData = new ArrayList<>();
    }

    public void addQuizResult(QuizResult quizResult) {
        leaderboardData.add(quizResult);
    }

    public List<QuizResult> getLeaderboardData() {
        return leaderboardData;
    }
}

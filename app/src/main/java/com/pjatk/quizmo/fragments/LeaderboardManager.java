package com.pjatk.quizmo.fragments;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardManager {
    private List<QuizResult> quizResults;

    public LeaderboardManager() {
        quizResults = new ArrayList<>();
    }

    public void addQuizResult(QuizResult quizResult) {
        quizResults.add(quizResult);
    }

    public List<QuizResult> getQuizResults() {
        return quizResults;
    }
}

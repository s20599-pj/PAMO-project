package com.pjatk.quizmo.logic;

import com.pjatk.quizmo.fragments.LeaderboardManager;
import com.pjatk.quizmo.fragments.QuizResult;

import java.util.List;

public class QuizManager {
    private List<QuizQuestion> quizQuestionList;
    private LeaderboardManager leaderboardManager;
    private int currentQuestionIndex;
    private int score;

    public QuizManager(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
        leaderboardManager = new LeaderboardManager();
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public void setQuizQuestionList(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
    }

    public int getScore() {
        return score;
    }

    public QuizQuestion getCurrentQuestionFromList(){
        return quizQuestionList.get(currentQuestionIndex);
    }

    public void answerQuestion(int selectedOption){
        QuizQuestion currentQuestion = getCurrentQuestionFromList();
        if(selectedOption == currentQuestion.getCorrectAnswer())
            score++;
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        boolean quizFinished = currentQuestionIndex >= quizQuestionList.size();
        if (quizFinished) {
            leaderboardManager.addQuizResult(new QuizResult("Player Name", score));
        }
        return quizFinished;
    }
}

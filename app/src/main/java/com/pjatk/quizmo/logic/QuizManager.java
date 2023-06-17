package com.pjatk.quizmo.logic;

import com.pjatk.quizmo.fragments.LeaderboardManager;
import com.pjatk.quizmo.fragments.QuizResult;

import java.io.Serializable;
import java.util.List;

public class QuizManager implements Serializable {
    private List<QuizQuestion> quizQuestionList;
    private LeaderboardManager leaderboardManager;
    private int currentQuestionIndex;
    private int score;

    // Constructor to initialize the QuizManager object
    public QuizManager(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
        leaderboardManager = new LeaderboardManager();
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    // Getter for retrieving the current score
    public int getScore() {
        return score;
    }

    // Method to get the current question from the list of quiz questions
    public QuizQuestion getCurrentQuestionFromList(){
        return quizQuestionList.get(currentQuestionIndex);
    }

    // Method to answer a question and update the score and current question index
    public void answerQuestion(int selectedOption){
        QuizQuestion currentQuestion = getCurrentQuestionFromList();
        if(selectedOption == currentQuestion.getCorrectAnswer())
            score++;
        currentQuestionIndex++;
    }

    // Method to check if the quiz is finished
    public boolean isQuizFinished() {
        boolean quizFinished = currentQuestionIndex >= quizQuestionList.size();
        if (quizFinished) {
            leaderboardManager.addQuizResult(new QuizResult("Player Name", score));
        }
        return quizFinished;
    }

    // Getter for retrieving the leaderboard manager
    public LeaderboardManager getLeaderboardManager() {
        return leaderboardManager;
    }
}

package com.pjatk.quizmo.logic;

import java.util.List;

public class QuizManager {
    private List<QuizQuestion> quizQuestionList;
    private int currentQuestionIndex;
    private int score;

    public QuizManager(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
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

    public boolean isQuizFinished(){
        return currentQuestionIndex >= quizQuestionList.size();
    }
}

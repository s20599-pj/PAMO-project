package com.pjatk.quizmo.logic;

import java.util.List;

public class QuizQuestion {
    private String question;
    private List<String> possibleAnswers;
    private int correctAnswer;

    // Constructor to initialize the QuizQuestion object
    public QuizQuestion(String question, List<String> possibleAnswers, int correctAnswer) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    // Getter for retrieving the question
    public String getQuestion() {
        return question;
    }

    // Getter for retrieving the possible answers
    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    // Getter for retrieving the index of the correct answer
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

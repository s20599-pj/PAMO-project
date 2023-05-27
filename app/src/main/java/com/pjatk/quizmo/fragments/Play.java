package com.pjatk.quizmo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.FragmentPlayBinding;
import com.pjatk.quizmo.logic.QuizManager;
import com.pjatk.quizmo.logic.QuizQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Play extends Fragment {

    private FragmentPlayBinding binding;
    private QuizManager quizManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<QuizQuestion> quizQuestionList = createQuizQuestions();

        quizManager = new QuizManager(quizQuestionList);

        showNextQuestionFromList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<QuizQuestion> createQuizQuestions(){
        List<QuizQuestion> quizQuestionList = new ArrayList<>();

        quizQuestionList.add(new QuizQuestion("Ile to jest 2+2?", Arrays.asList("1", "2", "3", "4"), 3));
        quizQuestionList.add(new QuizQuestion("Co to jest owca?", Arrays.asList("Roślina", "Owoc", "Zwierzę", "Rzecz"), 2));

        return quizQuestionList;
    }

    private void showNextQuestionFromList(){
        if (quizManager.isQuizFinished())
            showQuizResults();
        else {
            QuizQuestion currentQuestion = quizManager.getCurrentQuestionFromList();
            binding.questionPl.setText(currentQuestion.getQuestion());
            List<String> answers = currentQuestion.getPossibleAnswers();

            binding.answer1ButtonPl.setText(answers.get(0));
            binding.answer1ButtonPl.setOnClickListener(new AnswerClickListener(0));

            binding.answer2ButtonPl.setText(answers.get(1));
            binding.answer2ButtonPl.setOnClickListener(new AnswerClickListener(1));

            binding.answer3ButtonPl.setText(answers.get(2));
            binding.answer3ButtonPl.setOnClickListener(new AnswerClickListener(2));

            binding.answer4ButtonPl.setText(answers.get(3));
            binding.answer4ButtonPl.setOnClickListener(new AnswerClickListener(3));

            updateScore();
        }
    }
    
    private void showQuizResults(){
        Toast.makeText(getActivity(), "Koniec! Wynik: " + String.valueOf(quizManager.getScore()), Toast.LENGTH_SHORT).show();
        NavHostFragment.findNavController(Play.this)
                .navigate(R.id.action_play_to_menu);
    }
    
    private void updateScore(){
        binding.wynikTextviewChangable.setText("Score: " + quizManager.getScore());
    }
    
    private class AnswerClickListener implements View.OnClickListener {
        private int selectedAnswer;
        
        public AnswerClickListener(int selectedAnswer){
            this.selectedAnswer = selectedAnswer;
        }
        
        @Override
        public void onClick(View v){
            quizManager.answerQuestion(selectedAnswer);
            showNextQuestionFromList();
        }
    }
}
package com.pjatk.quizmo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.FragmentMenuBinding;
import com.pjatk.quizmo.logic.QuizManager;
import com.pjatk.quizmo.logic.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class Menu extends Fragment {

    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.leaderboardButtonPl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizManager quizManager = createQuizManager();

                Bundle args = new Bundle();
                args.putSerializable("quizManager", quizManager);

                NavHostFragment.findNavController(Menu.this)
                        .navigate(R.id.action_menu_to_leaderboardFragment, args);
            }
        });

        binding.startGameButtonPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizManager quizManager = createQuizManager();

                Bundle args = new Bundle();
                args.putSerializable("quizManager", quizManager);

                NavHostFragment.findNavController(Menu.this)
                        .navigate(R.id.action_menu_to_play, args);
            }
        });
    }

    private QuizManager createQuizManager() {
        List<QuizQuestion> quizQuestionList = new ArrayList<>();

        // ... Retrieve quiz questions and answers, populate quizQuestionList accordingly

        QuizManager quizManager = new QuizManager(quizQuestionList);
        // ... Perform any additional setup or calculations on the quizManager object if needed

        return quizManager;
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
}

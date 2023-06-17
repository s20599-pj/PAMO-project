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
import com.pjatk.quizmo.logic.LocalStorageManager;
import com.pjatk.quizmo.logic.QuizManager;
import com.pjatk.quizmo.logic.QuizQuestion;
import java.util.ArrayList;
import java.util.List;

public class Menu extends Fragment {

    private FragmentMenuBinding binding;
    private LocalStorageManager localStorageManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        localStorageManager = new LocalStorageManager();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.userNameField.setText(localStorageManager.getNickNameFromLocalStorage(getContext()));

        // Button click listener for leaderboard button
        binding.leaderboardButtonPl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create QuizManager object
                QuizManager quizManager = createQuizManager();

                // Pass the QuizManager object as an argument to the leaderboard fragment
                Bundle args = new Bundle();
                args.putSerializable("quizManager", quizManager);

                NavHostFragment.findNavController(Menu.this)
                        .navigate(R.id.action_menu_to_leaderboardFragment, args);
            }
        });

        // Button click listener for start game button
        binding.startGameButtonPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create QuizManager object
                QuizManager quizManager = createQuizManager();

                // Pass the QuizManager object as an argument to the choose game fragment
                Bundle args = new Bundle();
                args.putSerializable("quizManager", quizManager);

                NavHostFragment.findNavController(Menu.this)
                        .navigate(R.id.action_menu_to_choose_game, args);
            }
        });

        // Button click listener for saving the user name
        binding.userNameSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the new user name from the input field
                String newUserName = binding.userNameField.getText().toString();
                // Save the new user name to local storage
                localStorageManager.saveNickNameToLocalStorage(getContext(), newUserName);
            }
        });

    }

    /**
     * Creates a QuizManager object with a list of quiz questions.
     *
     * @return The QuizManager object.
     */
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

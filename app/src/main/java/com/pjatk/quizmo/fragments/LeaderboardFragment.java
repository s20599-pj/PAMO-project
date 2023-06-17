package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.pjatk.quizmo.databinding.FragmentLeaderboardBinding;
import com.pjatk.quizmo.logic.LocalStorageManager;
import com.pjatk.quizmo.logic.QuizManager;

public class LeaderboardFragment extends Fragment {

    private FragmentLeaderboardBinding binding;
    private LocalStorageManager localStorageManager;
    private QuizManager quizManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        localStorageManager = new LocalStorageManager();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the text of the leaderboard to display the player's name and score
        binding.leaderboardText.setText(localStorageManager.getLeaderboardNameToLocalStorage(getContext())+" : "+localStorageManager.getScoreFromLocalStorage(getContext()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up the binding when the view is destroyed
        binding = null;
    }
}

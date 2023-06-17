package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.FragmentLeaderboardBinding;
import com.pjatk.quizmo.logic.LocalStorageManager;
import com.pjatk.quizmo.logic.QuizManager;

import java.util.List;

public class LeaderboardFragment extends Fragment {

    private FragmentLeaderboardBinding binding;
    private LocalStorageManager localStorageManager;
    private QuizManager quizManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        localStorageManager = new LocalStorageManager();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.leaderboardText.setText(localStorageManager.getLeaderboardNameToLocalStorage(getContext())+" : "+localStorageManager.getScoreFromLocalStorage(getContext()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

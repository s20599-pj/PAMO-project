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
import com.pjatk.quizmo.logic.QuizManager;

import java.util.List;

public class LeaderboardFragment extends Fragment {

    private FragmentLeaderboardBinding binding;
    private QuizManager quizManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            quizManager = args.getParcelable("quizManager");
        }

        if (quizManager != null) {
            int score = quizManager.getScore();
            binding.scoreTextView.setText("Last Quiz Score: " + score);
        }

        // Retrieve leaderboard data
        List<QuizResult> leaderboardData = retrieveLeaderboardData();

        // Create adapter and set it to the RecyclerView
        LeaderboardAdapter adapter = new LeaderboardAdapter();
        adapter.setQuizResults(leaderboardData);
        binding.recyclerViewLeaderboard.setAdapter(adapter);

        // Set layout manager for the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerViewLeaderboard.setLayoutManager(layoutManager);

        // Ensure the adapter is not null and has data
        if (leaderboardData == null || leaderboardData.isEmpty()) {
            binding.recyclerViewLeaderboard.setVisibility(View.GONE);
            binding.scoreTextView.setVisibility(View.GONE);
        } else {
            binding.recyclerViewLeaderboard.setVisibility(View.VISIBLE);
            binding.scoreTextView.setVisibility(View.VISIBLE);
        }
    }

    private List<QuizResult> retrieveLeaderboardData() {
        if (quizManager != null) {
            LeaderboardManager leaderboardManager = quizManager.getLeaderboardManager();
            if (leaderboardManager != null) {
                return leaderboardManager.getLeaderboardData();
            }
        }
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

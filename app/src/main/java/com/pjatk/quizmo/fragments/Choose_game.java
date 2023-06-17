package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.FragmentChooseGameBinding;

public class Choose_game extends Fragment {

    private FragmentChooseGameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using the binding object
        binding = FragmentChooseGameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set click listeners for buttons
        binding.returnButtonPl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the menu fragment
                NavHostFragment.findNavController(Choose_game.this)
                        .navigate(R.id.action_choose_game_to_menu);
            }
        });
        binding.game1ButtonPl2.setOnClickListener(playButtonClickListener);
        binding.game2ButtonPl2.setOnClickListener(playButtonClickListener);
        binding.game3ButtonPl2.setOnClickListener(playButtonClickListener);
        binding.game4ButtonPl2.setOnClickListener(playButtonClickListener);
    }

    // Click listener for play buttons
    View.OnClickListener playButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String playButtonIdentifier = "";

            // Determine the play button identifier based on the clicked button
            if (v == binding.game1ButtonPl2){
                playButtonIdentifier = "game1";
            } else if (v == binding.game2ButtonPl2) {
                playButtonIdentifier = "game2";
            }else if (v == binding.game3ButtonPl2) {
                playButtonIdentifier = "game3";
            }else if (v == binding.game4ButtonPl2) {
                playButtonIdentifier = "game4";
            }

            // Create a bundle to pass the play button identifier to the play fragment
            Bundle args = new Bundle();
            args.putString("playButtonIdentifier", playButtonIdentifier);

            // Navigate to the play fragment with the play button identifier as an argument
            NavHostFragment.findNavController(Choose_game.this)
                    .navigate(R.id.action_choose_game_to_play, args);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.FragmentChooseGameBinding;
import com.pjatk.quizmo.databinding.FragmentPlayBinding;

public class Choose_game extends Fragment {

    private FragmentChooseGameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChooseGameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.returnButtonPl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Choose_game.this)
                        .navigate(R.id.action_choose_game_to_menu);
            }
        });
        binding.game1ButtonPl2.setOnClickListener(playButtonClickListener);
        binding.game2ButtonPl2.setOnClickListener(playButtonClickListener);
        binding.game3ButtonPl2.setOnClickListener(playButtonClickListener);
        binding.game4ButtonPl2.setOnClickListener(playButtonClickListener);
    }


    View.OnClickListener playButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String playButtonIdentifier = "";

            if (v == binding.game1ButtonPl2){
                playButtonIdentifier = "game1";
            } else if (v == binding.game2ButtonPl2) {
                playButtonIdentifier = "game2";
            }else if (v == binding.game3ButtonPl2) {
                playButtonIdentifier = "game3";
            }else if (v == binding.game4ButtonPl2) {
                playButtonIdentifier = "game4";
            }
            Bundle args = new Bundle();
            args.putString("playButtonIdentifier", playButtonIdentifier);

            NavHostFragment.findNavController(Choose_game.this)
                    .navigate(R.id.action_choose_game_to_play, args);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pjatk.quizmo.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment using the binding object
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // This method is called after the view has been created. You can perform any initialization or setup here.
        // It is a good place to set up event listeners or perform any UI-related operations.
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Release any resources or references held by the binding object
        binding = null;
    }
}

package com.pjatk.quizmo.fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.pjatk.quizmo.R;
import com.pjatk.quizmo.databinding.ActivityMainBinding;
import com.pjatk.quizmo.logic.QuizManager;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private LeaderboardManager leaderboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // Get the NavController associated with the main activity
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Retrieve the QuizManager object from the intent extras, if available
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("quizManager")) {
            QuizManager quizManager = (QuizManager) extras.getSerializable("quizManager");
            leaderboardManager = quizManager.getLeaderboardManager();
        } else {
            // Create a new LeaderboardManager object if the QuizManager is not available
            leaderboardManager = new LeaderboardManager();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle navigation events when the Up button is pressed
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

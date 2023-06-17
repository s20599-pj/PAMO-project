package com.pjatk.quizmo.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pjatk.quizmo.R;
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<QuizResult> quizResults;

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_leaderboard layout and create a new ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        // Bind the quiz result data to the ViewHolder at the given position
        QuizResult quizResult = quizResults.get(position);
        holder.bind(quizResult);
    }

    @Override
    public int getItemCount() {
        // Return the number of quiz results in the list
        return quizResults != null ? quizResults.size() : 0;
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        private TextView playerNameTextView;
        private TextView scoreTextView;

        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find the TextViews in the item layout
            playerNameTextView = itemView.findViewById(R.id.playerNameTextView);
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
        }

        public void bind(QuizResult quizResult) {
            // Set the text of the TextViews to display the player name and score
            playerNameTextView.setText(quizResult.getPlayerName());
            scoreTextView.setText(String.valueOf(quizResult.getScore()));
        }
    }
}

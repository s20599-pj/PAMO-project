package com.pjatk.quizmo.logic;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorageManager {
    // Method to save the nickname to local storage
    public void saveNickNameToLocalStorage(Context context, String userName){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", userName);
        editor.apply();
    }

    // Method to retrieve the nickname from local storage
    public String getNickNameFromLocalStorage(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Username", "User");
    }

    // Method to save the score to local storage
    public void saveScoreToLocalStorage(Context context, String score){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Score", score);
        editor.apply();
    }

    // Method to retrieve the score from local storage
    public String getScoreFromLocalStorage(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Score", "Score");
    }

    // Method to save the leaderboard name to local storage
    public void saveLeaderboardNameToLocalStorage(Context context, String userName){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LeaderboardName", userName);
        editor.apply();
    }

    // Method to retrieve the leaderboard name from local storage
    public String getLeaderboardNameToLocalStorage(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString("LeaderboardName", "Score");
    }
}

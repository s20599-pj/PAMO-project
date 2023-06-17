package com.pjatk.quizmo.logic;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorageManager {
    public void saveNickNameToLocalStorage(Context context, String userName){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", userName);
        editor.apply();
    }
    public String getNickNameFromLocalStorage(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Username", "User");
    }
    public void saveScoreToLocalStorage(Context context, String score){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Score", score);
        editor.apply();
    }
    public String getScoreFromLocalStorage(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Score", "Score");
    }
    public void saveLeaderboardNameToLocalStorage(Context context, String userName){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LeaderboardName", userName);
        editor.apply();
    }
    public String getLeaderboardNameToLocalStorage(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("QuizmoPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString("LeaderboardName", "Score");
    }
}

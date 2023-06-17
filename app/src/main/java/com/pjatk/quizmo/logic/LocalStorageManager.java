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
}

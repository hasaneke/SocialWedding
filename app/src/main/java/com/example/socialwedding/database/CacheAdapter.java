package com.example.socialwedding.database;


import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheAdapter {
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_MAIL ="email";
    private static final String KEY_PASSWORD ="password";
    Context context;
    static SharedPreferences sharedPreferences;
    public CacheAdapter(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
    }

    static public String checkUserExist () {
        String name=sharedPreferences.getString(KEY_MAIL,null);
        return name;
    }

    static public void saveUser(String email, String password){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_MAIL,email);
        editor.putString(KEY_PASSWORD,password);
        editor.apply();
    }

    static public void deleteUser() {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}

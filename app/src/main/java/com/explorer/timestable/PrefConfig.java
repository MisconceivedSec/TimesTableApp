package com.explorer.timestable;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {

    private static final String MY_PREFERENCE_NAME = "com.explorer.timestable";
    private static final String PREF_HS_KEY = "high_score";

    public static void store_high_score(Context context, int high_score) {
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(PREF_HS_KEY, high_score);
        editor.apply();

    }

    public static int retrieve_high_score(Context context) {
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return pref.getInt(PREF_HS_KEY, 0);
    }
}

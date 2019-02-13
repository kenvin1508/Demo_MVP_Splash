package vn.edu.vtn.demo_mvp_splash.db.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsHelper {
    public SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public SharedPrefsHelper(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("Splash", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setLoggedin(boolean loggedin, String username) {
        editor.putBoolean("log", loggedin);
        editor.putString("user", username);
        editor.commit();
    }

    public boolean checklogin() {
        return preferences.getBoolean("log", false);
    }

}

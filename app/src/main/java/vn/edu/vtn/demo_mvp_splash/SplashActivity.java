package vn.edu.vtn.demo_mvp_splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.edu.vtn.demo_mvp_splash.db.prefs.SaveInfoLogin;
import vn.edu.vtn.demo_mvp_splash.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    SaveInfoLogin saveInfoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saveInfoLogin = new SaveInfoLogin(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!saveInfoLogin.checklogin()) {
                    saveInfoLogin.setLoggedin(false, "");
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 3000);


    }
}

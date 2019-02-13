package vn.edu.vtn.demo_mvp_splash.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import vn.edu.vtn.demo_mvp_splash.MainActivity;
import vn.edu.vtn.demo_mvp_splash.db.prefs.SharedPrefsHelper;
import vn.edu.vtn.demo_mvp_splash.login.LoginActivity;

public class SplashActivity extends AppCompatActivity implements SplashMVP.View {
    SplashMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SplashPresenter(SplashActivity.this, this);
    }

    @Override
    public void showLoginActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    public void showMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}

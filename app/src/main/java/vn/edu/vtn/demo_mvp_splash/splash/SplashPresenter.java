package vn.edu.vtn.demo_mvp_splash.splash;

import android.content.Context;
import vn.edu.vtn.demo_mvp_splash.db.prefs.SharedPrefsHelper;

public class SplashPresenter implements SplashMVP.Presenter {
    SplashMVP.View view;
    SharedPrefsHelper sharedPrefsHelper;

    public SplashPresenter(Context context, SplashMVP.View view) {
        this.view = view;
        sharedPrefsHelper = new SharedPrefsHelper(context);
        checkStatusLogin();
    }

    private void checkStatusLogin() {
        if (!sharedPrefsHelper.checklogin()) {
            sharedPrefsHelper.setLoggedin(false, "");
            view.showLoginActivity();
        } else {
            view.showMainActivity();
        }
    }
}

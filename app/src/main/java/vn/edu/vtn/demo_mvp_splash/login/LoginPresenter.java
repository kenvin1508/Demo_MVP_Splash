package vn.edu.vtn.demo_mvp_splash.login;

import android.content.Context;

import vn.edu.vtn.demo_mvp_splash.MainActivity;
import vn.edu.vtn.demo_mvp_splash.db.HelperModel;

public class LoginPresenter implements LoginMVP.Presenter {
    LoginMVP.View view;
    Context context;

    public LoginPresenter(LoginMVP.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void checkLogin(String username, String password) {
        HelperModel helperModel = new HelperModel(context);
        if (helperModel.checkLogin(username, password)) {
            view.showResult(true, username);
        } else {
            view.showResult(false, "");
        }
    }
}

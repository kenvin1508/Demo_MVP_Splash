package vn.edu.vtn.demo_mvp_splash.info;

import android.content.Context;

import vn.edu.vtn.demo_mvp_splash.db.HelperModel;

public class InfoPresenter implements InfoMVP.Presenter {
    InfoMVP.view view;
    Context context;
    HelperModel helperModel;

    public InfoPresenter(Context context, InfoMVP.view view) {
        this.context = context;
        this.view = view;
        helperModel = new HelperModel(context);
    }

    @Override
    public void loadInfo(String username) {
        view.showInfo(helperModel.getDataFromUsername(username));
    }
}

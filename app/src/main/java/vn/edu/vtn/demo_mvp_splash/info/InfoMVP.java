package vn.edu.vtn.demo_mvp_splash.info;

import vn.edu.vtn.demo_mvp_splash.db.model.Info;

public interface InfoMVP {
    interface view {
        void showInfo(Info info);
    }

    interface Presenter {
        void loadInfo(String username);
    }
}

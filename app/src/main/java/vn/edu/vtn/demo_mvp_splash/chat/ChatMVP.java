package vn.edu.vtn.demo_mvp_splash.chat;

import java.util.ArrayList;

import vn.edu.vtn.demo_mvp_splash.db.model.Message;

public interface ChatMVP {
    interface View {
        void showDataOnRV(ArrayList<Message> listMess);

        void swipeRefresh();
    }

    interface Presenter {
        void loadData();

        void processData( );
    }

    interface OnResponseCallback {
        void onResponse(ArrayList<Message> listMess);
    }
}

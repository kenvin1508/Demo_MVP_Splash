package vn.edu.vtn.demo_mvp_splash.chat;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import vn.edu.vtn.demo_mvp_splash.db.model.Message;

public class ChatPresenter implements ChatMVP.Presenter, ChatMVP.OnResponseCallback {
    ChatMVP.View view;

    FakeData fakeData;

    ArrayList<Message> listMess;

    public ChatPresenter(ChatMVP.View view) {
        this.view = view;
        fakeData = new FakeData(this);
        view.swipeRefresh();
    }

    @Override
    public void loadData() {
        fakeData.getDataResponse();
    }

    @Override
    public void processData() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int n = random.nextInt(9);
            listMess.add(0, listMess.get(n));
        }
    }

    @Override
    public void onResponse(ArrayList<Message> listMess) {
        view.showDataOnRV(listMess);
        this.listMess = listMess;
    }
}

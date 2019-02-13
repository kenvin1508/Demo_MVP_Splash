package vn.edu.vtn.demo_mvp_splash.chat;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Random;

import vn.edu.vtn.demo_mvp_splash.db.model.Message;
import vn.edu.vtn.demo_mvp_splash.R;

public class ChatFragment extends Fragment implements ChatMVP.View {
    RecyclerView rvChat;
    ChatAdapter chatAdapter;
    LinearLayoutManager layoutManager;

    SwipeRefreshLayout swipe;
    ProgressBar progressBar;
    boolean isScrolling = false;
    int currentItem, totalItem, scrollOutItem;

    ChatMVP.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_chat, container, false);
        addControls(view);
        //  addEvents();
        return view;
    }

    private void addControls(View view) {
        rvChat = view.findViewById(R.id.rvChat);
        swipe = view.findViewById(R.id.swipe);
        progressBar = view.findViewById(R.id.progressBar);

        presenter = new ChatPresenter(this);
        presenter.loadData();

        layoutManager = new LinearLayoutManager(getActivity());
        rvChat.setLayoutManager(layoutManager);
        rvChat.setItemAnimator(new DefaultItemAnimator());


    }

//    private void addEvents() {
//        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i < 5; i++) {
//                            Random random = new Random();
//                            int n = random.nextInt(9);
//                            listMessages.add(0, listMessages.get(n));
//                        }
//                        swipe.setRefreshing(false);
//                        chatAdapter.notifyDataSetChanged();
//                    }
//                }, 1500);
//
//            }
//        });
//        rvChat.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isScrolling = true;
//                }
//
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                currentItem = layoutManager.getChildCount();
//                totalItem = layoutManager.getItemCount();
//                scrollOutItem = layoutManager.findFirstVisibleItemPosition();
//                if (isScrolling && (scrollOutItem + currentItem == totalItem)) {
//                    isScrolling = false;
//                    loadMore();
//                }
//
//            }
//        });
//    }

//    private void loadMore() {
//        progressBar.setVisibility(View.VISIBLE);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    Random random = new Random();
//                    int n = random.nextInt(9);
//                    listMessages.add(listMessages.get(n));
//                }
//                progressBar.setVisibility(View.GONE);
//                chatAdapter.notifyDataSetChanged();
//            }
//        }, 1500);
//    }


    @Override
    public void showDataOnRV(ArrayList<Message> listMess) {
        chatAdapter = new ChatAdapter(listMess, getActivity());
        rvChat.setAdapter(chatAdapter);
    }

    @Override
    public void swipeRefresh() {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.processData();
                        swipe.setRefreshing(false);
                        chatAdapter.notifyDataSetChanged();
                    }
                }, 1500);

            }
        });
    }
}

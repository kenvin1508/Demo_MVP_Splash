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

public class ChatFragment extends Fragment {
    RecyclerView rvChat;
    ArrayList<Message> listMessages;
    ChatAdapter chatAdapter;
    LinearLayoutManager layoutManager;

    SwipeRefreshLayout swipe;
    ProgressBar progressBar;
    boolean isScrolling = false;
    int currentItem, totalItem, scrollOutItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_chat, container, false);
        addControls(view);
        addEvents();
        return view;
    }

    private void addControls(View view) {
        rvChat = view.findViewById(R.id.rvChat);
        swipe = view.findViewById(R.id.swipe);
        progressBar = view.findViewById(R.id.progressBar);
        listMessages = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        fakeData();
        rvChat.setLayoutManager(layoutManager);
        chatAdapter = new ChatAdapter(listMessages, getActivity());
        rvChat.setItemAnimator(new DefaultItemAnimator());
        rvChat.setAdapter(chatAdapter);

    }

    private void addEvents() {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            Random random = new Random();
                            int n = random.nextInt(9);
                            listMessages.add(0, listMessages.get(n));
                        }
                        swipe.setRefreshing(false);
                        chatAdapter.notifyDataSetChanged();
                    }
                }, 1500);

            }
        });
        rvChat.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItem = layoutManager.getChildCount();
                totalItem = layoutManager.getItemCount();
                scrollOutItem = layoutManager.findFirstVisibleItemPosition();
                if (isScrolling && (scrollOutItem + currentItem == totalItem)) {
                    isScrolling = false;
                    loadMore();
                }

            }
        });
    }

    private void loadMore() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Random random = new Random();
                    int n = random.nextInt(9);
                    listMessages.add(listMessages.get(n));
                }
                progressBar.setVisibility(View.GONE);
                chatAdapter.notifyDataSetChanged();
            }
        }, 1500);
    }

    public void fakeData() {
        listMessages.add(new Message(1, "Nghia", "Hello"));
        listMessages.add(new Message(2, "Tung", "Hello"));
        listMessages.add(new Message(3, "Nghia", "Nice to meet you !!!"));
        listMessages.add(new Message(4, "Tung", "Nice to meet you too !!!"));
        listMessages.add(new Message(5, "Nghia", "How are you ?"));
        listMessages.add(new Message(6, "Tung", "I'm good , about you ?"));
        listMessages.add(new Message(7, "Nghia", "I'm fine"));
        listMessages.add(new Message(8, "Tung", "what are you doing now ?"));
        listMessages.add(new Message(9, "Nghia", "I'm watching TV"));
        listMessages.add(new Message(10, "Tung", "What is a channel do you watching?"));
        listMessages.add(new Message(11, "Nghia", "HBO channel "));
//        listMessages.add(new Message(12, "Tung", "Ohh , that is my favorite channel too "));
//        listMessages.add(new Message(13, "Nghia", "There are many great movie on it "));
//        listMessages.add(new Message(14, "Tung", "Yes, I often watch action movie, it's very interesting"));
//        listMessages.add(new Message(15, "Nghia", "what kind of movie do you like?"));
//        listMessages.add(new Message(16, "Tung", "science fiction movies"));
//        listMessages.add(new Message(17, "Nghia", "Hey Tung, it's beautiful out today, isn't it?"));
//        listMessages.add(new Message(18, "Tung", "Yeah. I wish it would be like this everyday."));
//        listMessages.add(new Message(19, "Nghia", "Did you see the weather forecast?"));
//        listMessages.add(new Message(20, "Tung", "Unfortunately, it's supposed to start raining tomorrow night.!"));
//        listMessages.add(new Message(21, "Nghia", "I'm really happy that you could come."));
//        listMessages.add(new Message(22, "Tung", "Yeah. It's been years since we did this together"));
//        listMessages.add(new Message(23, "Nghia", "I know. It has been a long time"));
//        listMessages.add(new Message(24, "Tung", "Well, anyway, a drink to our friendship!"));
//        listMessages.add(new Message(25, "Nghia", "Cheers!"));
//
//        listMessages.add(new Message(26, "Nghia", "Hello"));
//        listMessages.add(new Message(27, "Tung", "Hello"));
//        listMessages.add(new Message(28, "Nghia", "Nice to meet you !!!"));
//        listMessages.add(new Message(29, "Tung", "Nice to meet you too !!!"));
//        listMessages.add(new Message(30, "Nghia", "How are you ?"));
//        listMessages.add(new Message(31, "Tung", "I'm good , about you ?"));
//        listMessages.add(new Message(32, "Nghia", "I'm fine"));
//        listMessages.add(new Message(33, "Tung", "what are you doing now ?"));
//        listMessages.add(new Message(34, "Nghia", "I'm watching TV"));
//        listMessages.add(new Message(35, "Tung", "What is a channel do you watching?"));
//        listMessages.add(new Message(36, "Nghia", "HBO channel "));
//        listMessages.add(new Message(37, "Tung", "Ohh , that is my favorite channel too "));
//        listMessages.add(new Message(38, "Nghia", "There are many great movie on it "));
//        listMessages.add(new Message(39, "Tung", "Yes, I often watch action movie, it's very interesting"));
//        listMessages.add(new Message(40, "Nghia", "what kind of movie do you like?"));
//        listMessages.add(new Message(41, "Tung", "science fiction movies"));
//        listMessages.add(new Message(42, "Nghia", "Hey Tung, it's beautiful out today, isn't it?"));
//        listMessages.add(new Message(43, "Tung", "Yeah. I wish it would be like this everyday."));
//        listMessages.add(new Message(44, "Nghia", "Did you see the weather forecast?"));
//        listMessages.add(new Message(45, "Tung", "Unfortunately, it's supposed to start raining tomorrow night.!"));
//        listMessages.add(new Message(46, "Nghia", "I'm really happy that you could come."));
//        listMessages.add(new Message(47, "Tung", "Yeah. It's been years since we did this together"));
//        listMessages.add(new Message(48, "Nghia", "I know. It has been a long time"));
//        listMessages.add(new Message(49, "Tung", "Well, anyway, a drink to our friendship!"));
//        listMessages.add(new Message(50, "Nghia", "Cheers!"));


    }
}

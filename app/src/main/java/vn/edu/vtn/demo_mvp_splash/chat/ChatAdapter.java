package vn.edu.vtn.demo_mvp_splash.chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.vtn.demo_mvp_splash.db.model.Message;
import vn.edu.vtn.demo_mvp_splash.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    ArrayList<Message> listMess;
    Context context;
    public final int SENDER = 0;
    public final int RECEIVER = 1;


    public ChatAdapter(ArrayList<Message> listMess, Context context) {
        this.context = context;
        this.listMess = listMess;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        if (i == 0) {
            View view = inflater.inflate(R.layout.item_send, viewGroup, false);
            return new ViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_receive, viewGroup, false);
            return new ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(i);
    }


    @Override
    public int getItemCount() {
        return listMess.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMess;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMess = itemView.findViewById(R.id.txtMessage);
        }

        void bindData(int position) {
            Message message = listMess.get(position);
            txtMess.setText(message.getContentMessage());
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = listMess.get(position);
        if (message.getSenderName().equals("Nghia")) {
            return SENDER;
        } else {
            return RECEIVER;
        }

    }

}

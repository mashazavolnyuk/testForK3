package com.example.masha.testfork3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masha.testfork3.R;
import com.example.masha.testfork3.data.User;

import java.util.ArrayList;
import java.util.List;

public class AdapterListData extends RecyclerView.Adapter<AdapterListData.HolderAdapter> {

    private List<User> userList;
    private RecyclerViewOnClickListener onClickListener;

    public interface RecyclerViewOnClickListener {
        void onClick(User user);
    }

    public AdapterListData(RecyclerViewOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.userList = new ArrayList<>();
    }


    @Override
    public AdapterListData.HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        return new HolderAdapter(itemView, onClickListener);
    }

    @Override
    public void onBindViewHolder(AdapterListData.HolderAdapter holder, int position) {
        holder.title.setText( userList.get(position).getTitle());
        holder.body.setText( userList.get(position).getBody());
        holder.user = userList.get(position);
    }

    public void updateData(List<User> userList) {
        this.userList.clear();
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        } else {
            return 0;
        }
    }

    class HolderAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView body;
        User user;

        private RecyclerViewOnClickListener listener;

        HolderAdapter(View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.listener.onClick(user);
        }
    }
}
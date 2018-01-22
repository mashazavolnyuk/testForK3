package com.example.masha.testfork3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masha.testfork3.R;
import com.example.masha.testfork3.data.User;

import java.util.List;

public class AdapterListData extends RecyclerView.Adapter<AdapterListData.HolderAdapter> {

    private List<User> userList;

    public interface RecyclerViewOnClickListener{
        void onClick();
    }

    @Override
    public AdapterListData.HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        return new HolderAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterListData.HolderAdapter holder, int position) {
        holder.title.setText(String.format("Title:%s", userList.get(position).getTitle()));
        holder.body.setText(String.format("Body:%s", userList.get(position).getBody()));
    }

    public void updateData(List<User> userList) {
        this.userList = userList;
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

    class HolderAdapter extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;

        HolderAdapter(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
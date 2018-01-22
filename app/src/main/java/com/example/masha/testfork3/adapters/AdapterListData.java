package com.example.masha.testfork3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masha.testfork3.R;

import java.util.List;

public class AdapterListData  extends RecyclerView.Adapter<AdapterListData.HolderAdapter> {

    List<Object> objectList;
    @Override
    public AdapterListData.HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        return new HolderAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterListData.HolderAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class HolderAdapter extends RecyclerView.ViewHolder {

        public HolderAdapter(View itemView) {
            super(itemView);
        }
    }
}
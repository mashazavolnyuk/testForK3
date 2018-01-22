package com.example.masha.testfork3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.masha.testfork3.R;
import com.example.masha.testfork3.adapters.AdapterListData;
import com.example.masha.testfork3.data.User;
import com.example.masha.testfork3.mvp.presenter.MainListPresenter;
import com.example.masha.testfork3.mvp.view.MainListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentMainList extends MvpAppCompatFragment implements MainListView {

    @BindView(R.id.listUser)
    RecyclerView recyclerViewUsers;

    @InjectPresenter
    MainListPresenter mainListPresenter;

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void loadListUser(List<User> userList) {
        AdapterListData adapterListData = new AdapterListData();
        adapterListData.updateData(userList);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewUsers.setAdapter(adapterListData);
        recyclerViewUsers.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
package com.example.masha.testfork3.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.masha.testfork3.data.User;

import java.util.List;

public interface MainListView extends MvpView {

    void loadListUser(List<User> userList);
}
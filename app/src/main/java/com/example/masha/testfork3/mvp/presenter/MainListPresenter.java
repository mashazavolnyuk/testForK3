package com.example.masha.testfork3.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.masha.testfork3.data.User;
import com.example.masha.testfork3.mvp.model.MainListModel;
import com.example.masha.testfork3.mvp.view.MainListView;

import java.util.List;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class MainListPresenter extends MvpPresenter<MainListView> {

    private MainListModel mainListModel;

    public MainListPresenter() {
        mainListModel = new MainListModel();
        loadUsers();
    }

    public void loadUsers() {
        mainListModel.getUsers(new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<User> value) {
                getViewState().loadListUser(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
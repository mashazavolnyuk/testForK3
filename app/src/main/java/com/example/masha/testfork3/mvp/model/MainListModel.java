package com.example.masha.testfork3.mvp.model;

import com.example.masha.testfork3.api.RetrofitClient;
import com.example.masha.testfork3.api.requests.IRequestUsers;
import com.example.masha.testfork3.data.User;

import java.util.List;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainListModel {

    public void getUsers(final Observer<List<User>> observer) {

        IRequestUsers iRequestListPlaces = RetrofitClient.getRetrofit().create(IRequestUsers.class);
        iRequestListPlaces.getMainList().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                observer.onNext(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                observer.onError(t);
            }
        });
    }
}
package com.example.masha.testfork3.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.masha.testfork3.BundleKeys;
import com.example.masha.testfork3.R;
import com.example.masha.testfork3.data.User;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentDetail extends MvpAppCompatFragment {

    @BindView(R.id.idUser)
    TextView idUser;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.body)
    TextView body;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String formatForUser = bundle.getString(BundleKeys.KEY_USER);
            User user = new Gson().fromJson(formatForUser, User.class);
            title.setText(user.getTitle());
            body.setText(user.getBody());
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
package com.example.masha.testfork3;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.masha.testfork3.data.User;
import com.example.masha.testfork3.fragments.FragmentDetail;
import com.example.masha.testfork3.fragments.FragmentMainList;
import com.google.gson.Gson;

public class MainActivity extends MvpAppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        goToListData();
    }

    public void goToListData() {
        goToFragment(new FragmentMainList(), null);
    }

    public void goToDetail(User user) {
        String formattedData = new Gson().toJson(user);
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeys.KEY_USER, formattedData);
        goToFragment(new FragmentDetail(), bundle);
    }

    private void goToFragment(Fragment fragment, Bundle bundle) {
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentManager.beginTransaction().replace(R.id.content, fragment)
                .addToBackStack(fragment.getTag()).commit();
    }
}

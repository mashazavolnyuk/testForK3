package com.example.masha.testfork3;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.masha.testfork3.fragments.FragmentDetail;
import com.example.masha.testfork3.fragments.FragmentMainList;

public class MainActivity extends MvpAppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToListData();
    }

    public void goToListData() {
        goToFragment(new FragmentMainList());
    }

    public void goToDetail() {
        goToFragment(new FragmentDetail());
    }

    private void goToFragment(Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.content, fragment)
                .addToBackStack(fragment.getTag()).commit();
    }
}

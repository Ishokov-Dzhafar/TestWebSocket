package com.test.testwebsocket.View.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.testwebsocket.R;
import com.test.testwebsocket.View.Fragment.ListIEXFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment fragment = new ListIEXFragment();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

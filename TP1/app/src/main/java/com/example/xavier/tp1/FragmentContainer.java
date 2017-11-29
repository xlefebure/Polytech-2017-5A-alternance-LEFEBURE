package com.example.xavier.tp1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Epulapp on 29/11/2017.
 */

public class FragmentContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentcontainer);

        replaceFragment(R.id.FragmentContainer, new MenuFragment());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
    }

    public void replaceFragment(int id, Fragment fragment){
        FragmentManager fm  = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction().replace(id, fragment);
        ft.commit();
    }
}

package com.example.xavier.tp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
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
}

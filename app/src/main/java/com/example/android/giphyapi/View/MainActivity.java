package com.example.android.giphyapi.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.android.giphyapi.R;

public class MainActivity extends AppCompatActivity {
    MainFragment mainView;
    FragmentManager theManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theManager = getSupportFragmentManager();
        mainView = (MainFragment) theManager.findFragmentById(R.id.mainFragment);
    }
}

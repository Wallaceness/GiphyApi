package com.example.android.giphyapi.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.android.giphyapi.R;



public class MainActivity extends AppCompatActivity {
    FragmentManager theManager;
    private NavHostFragment navHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theManager = getSupportFragmentManager();
        navHost = (NavHostFragment) theManager.findFragmentById(R.id.nav_host_fragment);
//        viewModel.fetchGIFData("Snoopy");
    }

    public void navigateTo(int id){
        NavHostFragment.findNavController(navHost).navigate(id);
    }

}

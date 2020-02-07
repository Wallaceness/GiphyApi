package com.example.android.giphyapi.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.giphyapi.R;
import com.example.android.giphyapi.ViewModel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainFragment mainView;
    FragmentManager theManager;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theManager = getSupportFragmentManager();
        mainView = (MainFragment) theManager.findFragmentById(R.id.mainFragment);
        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);
        setUpObservers();
        viewModel.fetchGIFData("Snoopy");
    }

    private void setUpObservers() {
        viewModel.getGIFSLiveData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> urls) {
                if (urls != null) {
                    if (!urls.isEmpty())
                        mainView.loadPicasso(urls.get(1));
                    else
                        Toast.makeText(MainActivity.this, "NO DATA", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getErrorLiveData().observe(this, isError -> {
            if (!isError.isEmpty())
                Toast.makeText(this, isError, Toast.LENGTH_SHORT).show();
        });
    }
}

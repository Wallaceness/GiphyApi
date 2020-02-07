package com.example.android.giphyapi.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.giphyapi.R;
import com.example.android.giphyapi.ViewModel.MainViewModel;
import com.example.android.giphyapi.model.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainFragment mainView;
    FragmentManager theManager;
    private MainViewModel viewModel;
    Button searchButton;
    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton = findViewById(R.id.searchButton);
        searchText = findViewById(R.id.headerDiv);
        theManager = getSupportFragmentManager();
        mainView = (MainFragment) theManager.findFragmentById(R.id.mainFragment);
        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);
        setUpObservers();
        viewModel.fetchGIFData("Snoopy");
    }

    private void setUpObservers() {
        viewModel.getGIFSLiveData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response urls) {
                if (urls != null) {
                    if (!urls.getData().isEmpty()){
                        mainView.loadGlide(urls.getData().get(0).getImages().getOriginal().getUrl());

                    }
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

    public void fetchGifs(View view) {
        viewModel.fetchGIFData(searchText.getText().toString());
    }
}

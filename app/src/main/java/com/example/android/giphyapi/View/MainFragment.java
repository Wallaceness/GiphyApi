package com.example.android.giphyapi.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.giphyapi.R;
import com.example.android.giphyapi.ViewModel.MainViewModel;
import com.example.android.giphyapi.model.Response;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ImageView theGIF;
    private Button searchButton;
    private EditText searchText;
    private MainActivity main;
    private Button nextButton;
    private MainViewModel viewModel;
    private Response responses;
    private int position=0;
    private Button navButton;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        theGIF = rootView.findViewById(R.id.androidGIF);
        searchButton = rootView.findViewById(R.id.searchButton);
        searchText = rootView.findViewById(R.id.headerDiv);
        nextButton = rootView.findViewById(R.id.nextButton);
        navButton = rootView.findViewById(R.id.navButton1);
        main = (MainActivity) getActivity();
        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);
        setUpObservers();


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.fetchGIFData(searchText.getText().toString(), 0);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment.this.position+=1;
                if ((position+1)%25==1 && position>1){
                    viewModel.fetchGIFData(searchText.getText().toString(), ((position+1)/25)*25);
                }
                else if (responses!=null){
                    loadGlide(responses.getData().get(position%25).getImages().getOriginal().getUrl());
                }
            }
        });

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.navigateTo(R.id.recyclerFragment);
            }
        });

        return rootView;
    }

    private void setUpObservers() {
        viewModel.getGIFSLiveData().observe(getViewLifecycleOwner(), new Observer<Response>() {
            @Override
            public void onChanged(Response urls) {
                if (urls != null) {
                    if (!urls.getData().isEmpty()){
                        loadGlide(urls.getData().get(0).getImages().getOriginal().getUrl());
                        responses = urls;
                    }
                    else
                        Toast.makeText(main, "NO DATA", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getErrorLiveData().observe(getViewLifecycleOwner(), isError -> {
            if (!isError.isEmpty())
                Toast.makeText(main, isError, Toast.LENGTH_SHORT).show();
        });
    }

    private void loadGlide(String url){
        Glide.with(requireContext())
                .load(url)
                .into(theGIF);

    }
}

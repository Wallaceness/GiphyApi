package com.example.android.giphyapi.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.giphyapi.R;
import com.example.android.giphyapi.ViewModel.MainViewModel;
import com.example.android.giphyapi.model.DataItem;
import com.example.android.giphyapi.model.Response;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {

    private Button searchButton;
    private EditText searchText;
    private MainActivity main;
    private MainViewModel viewModel;
    private RecyclerView gifRecycler;
    private ArrayList<DataItem> gifs;
    private RecycleAdapter gifAdapter;
    private Button BackButton;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_recycler, container, false);
        searchButton = rootView.findViewById(R.id.searchButton2);
        searchText = rootView.findViewById(R.id.editText1);
        BackButton = rootView.findViewById(R.id.backButton2);
        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);
        main = (MainActivity) getActivity();
        gifRecycler = rootView.findViewById(R.id.recycleGrid);
        setUpObservers();
        gifs = new ArrayList<DataItem>();

        //set up adapter
        gifAdapter= new RecycleAdapter(gifs, this);
        gifRecycler.setAdapter(gifAdapter);
        gifRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 4));


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.fetchGIFData(searchText.getText().toString(), 0);
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.navigateTo(R.id.mainFragment);
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
                        gifs = (ArrayList) urls.getData();
                        gifAdapter.resizeView(gifs);
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

}

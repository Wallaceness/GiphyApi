package com.example.android.giphyapi.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.giphyapi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FullscreenFragment extends Fragment implements View.OnSystemUiVisibilityChangeListener, View.OnClickListener{
    private ImageView fullscreenImage;


    public FullscreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fullscreen, container, false);
        fullscreenImage = rootView.findViewById(R.id.fullscreenImage);
        String url = FullscreenFragmentArgs.fromBundle(getArguments()).getImageUrl();
        Glide.with(fullscreenImage.getContext()).load(url).into(fullscreenImage);
        System.out.println("!!!@#$%!!!");
        System.out.println(rootView.getSystemUiVisibility());
        fullscreenImage.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
        return rootView;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onSystemUiVisibilityChange(int visibility) {

    }
}

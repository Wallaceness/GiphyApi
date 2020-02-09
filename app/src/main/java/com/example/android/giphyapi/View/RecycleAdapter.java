package com.example.android.giphyapi.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.giphyapi.R;
import com.example.android.giphyapi.model.DataItem;
import com.example.android.giphyapi.model.Response;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.GifHolder> {

    private ArrayList<DataItem> gifs;
    private LayoutInflater inflater;
    private RecyclerFragment parent;

    public RecycleAdapter(ArrayList<DataItem> gifs, RecyclerFragment context){
        this.gifs = gifs;
        parent = context;
    }

    @NonNull
    @Override
    public GifHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = inflater.inflate(R.layout.gif_item, parent, false);
        return new GifHolder(holder, this);
    }

    @Override
    public void onBindViewHolder(@NonNull GifHolder holder, int position) {
        Glide.with(holder.ada.parent).load(gifs.get(position).getImages().getOriginal().getUrl()).into(holder.gif);
    }

    @Override
    public int getItemCount() {
        return gifs.size();
    }

    class GifHolder extends RecyclerView.ViewHolder{
        private ImageView gif;
        private RecycleAdapter ada;

        GifHolder(View v, RecycleAdapter adapter){
            super(v);
            gif=v.findViewById(R.id.gifItem);
            ada=adapter;
        }
    }
}

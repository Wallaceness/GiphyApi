package com.example.android.giphyapi.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.giphyapi.R;
import com.example.android.giphyapi.model.DataItem;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.GifHolder> {

    private ArrayList<DataItem> gifs;

    public RecycleAdapter(ArrayList<DataItem> gifs, RecyclerFragment context){
        this.gifs = gifs;
    }

    @NonNull
    @Override
    public GifHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.gif_item, parent, false);
        return new GifHolder(holder, this);
    }

    @Override
    public void onBindViewHolder(@NonNull GifHolder holder, int position) {
        String url = gifs.get(position).getImages().getOriginal().getUrl();
        Glide.with(holder.gif.getContext()).load(url).into(holder.gif);
        holder.gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerFragmentDirections.ActionRecyclerFragmentToFullscreenFragment action = RecyclerFragmentDirections.actionRecyclerFragmentToFullscreenFragment();
                action.setImageUrl(url);
                Navigation.findNavController(v).navigate(action);
            }
        });
    }

    public void resizeView(ArrayList<DataItem> gifs){
        this.gifs.addAll(gifs);
//        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return gifs.size();
    }

    class GifHolder extends RecyclerView.ViewHolder{
        ImageView gif;
        RecycleAdapter ada;

        GifHolder(View v, RecycleAdapter adapter){
            super(v);
            gif=v.findViewById(R.id.gifItem);
            ada=adapter;
        }
    }
}

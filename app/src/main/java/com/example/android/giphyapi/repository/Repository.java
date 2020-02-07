package com.example.android.giphyapi.repository;

import com.example.android.giphyapi.View.APIKey;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {


    private Repository() {
    }

    private static final Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static class RepositoryHolder {
        private static final Repository INSTANCE = new Repository();
    }
    public static Repository getInstance() {
        return RepositoryHolder.INSTANCE;
    }

    public Call<List<String>> getGIF(String query) {
        return RETROFIT.create(Giphy.class)
                .getGIF(
                        query,
                        APIKey.getKey(),
                        1
                );
    }
}

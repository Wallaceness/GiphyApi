package com.example.android.giphyapi.repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Giphy {
    @GET(Constants.URL_PATH)
    Call<List<String>> getGIF(
            @Query("q") String query,
            @Query("api_key") String Key,
            @Query("limit") int limit);
}

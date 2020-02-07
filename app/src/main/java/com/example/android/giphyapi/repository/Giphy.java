package com.example.android.giphyapi.repository;

import com.example.android.giphyapi.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Giphy {
    @GET(Constants.URL_PATH)
    Call<Response> getGIF(
            @Query("q") String query,
            @Query("api_key") String Key,
            @Query("limit") int limit);
}

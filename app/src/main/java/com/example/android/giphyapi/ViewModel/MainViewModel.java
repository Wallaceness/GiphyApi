package com.example.android.giphyapi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.giphyapi.repository.Repository;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<com.example.android.giphyapi.model.Response> GIFS = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    private Repository repo = Repository.getInstance();

    public void fetchGIFData(String query, int offset) {
        repo.getGIF(query, offset)
                .enqueue(new Callback<com.example.android.giphyapi.model.Response>() {
                    @Override
                    public void onResponse(Call<com.example.android.giphyapi.model.Response> call, Response<com.example.android.giphyapi.model.Response> response) {
                        GIFS.postValue(response.body());
                        error.postValue("");
                    }

                    @Override
                    public void onFailure(Call<com.example.android.giphyapi.model.Response> call, Throwable t) {
                        GIFS.postValue(new com.example.android.giphyapi.model.Response());
                        error.postValue(t.getMessage());
                    }
                });
    }

    public int getNumber() {
        return new Random().nextInt(10);
    }

    public LiveData<com.example.android.giphyapi.model.Response> getGIFSLiveData() {
        return GIFS;
    }

    public LiveData<String> getErrorLiveData() {
        return error;
    }
}

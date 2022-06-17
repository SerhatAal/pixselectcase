package com.example.pixselectcase.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.pixselectcase.entity.DogImageResponse;
import com.example.pixselectcase.entity.DogsResponse;
import com.example.pixselectcase.retrofit.DogsApiService;
import com.example.pixselectcase.retrofit.RetrofitClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogsDaoRepository {
    private final DogsApiService dogsApiService;


    public DogsDaoRepository() {
        dogsApiService = RetrofitClient.getRetrofitInstance();
    }

    public void getAllDogs(MutableLiveData<DogsResponse> dogList) {
        dogsApiService.getDogs().enqueue(new Callback<DogsResponse>() {
            @Override
            public void onResponse(Call<DogsResponse> call, Response<DogsResponse> response) {
                dogList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DogsResponse> call, Throwable t) {

            }
        });
    }

    public void getAllBreedImages(MutableLiveData<DogImageResponse> imageList, String breedName) {
        dogsApiService.getBreedImages(breedName).enqueue(new Callback<DogImageResponse>() {
            @Override
            public void onResponse(Call<DogImageResponse> call, Response<DogImageResponse> response) {
                imageList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DogImageResponse> call, Throwable t) {

            }
        });
    }
}

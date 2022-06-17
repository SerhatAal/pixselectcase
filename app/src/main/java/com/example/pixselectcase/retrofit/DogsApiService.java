package com.example.pixselectcase.retrofit;

import com.example.pixselectcase.entity.DogImageResponse;
import com.example.pixselectcase.entity.DogsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogsApiService {
    @GET("api/breeds/list/all")
    Call<DogsResponse> getDogs();

    @GET("https://dog.ceo/api/breed/{breedName}/images")
    Call<DogImageResponse> getBreedImages(@Path(value = "breedName") String breedName);
}

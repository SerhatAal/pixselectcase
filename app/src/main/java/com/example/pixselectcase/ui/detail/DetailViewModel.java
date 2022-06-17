package com.example.pixselectcase.ui.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.pixselectcase.entity.DogImageResponse;
import com.example.pixselectcase.repository.DogsDaoRepository;

public class DetailViewModel extends AndroidViewModel {

    private final DogsDaoRepository dogsDaoRepository;
    private MutableLiveData<DogImageResponse> dogImageListLiveData;

    public DetailViewModel(@NonNull Application application) {
        super(application);
        dogsDaoRepository = new DogsDaoRepository();
    }

    void getBreedImages(String breedName) {
        dogsDaoRepository.getAllBreedImages(getDogImageListLiveData(), breedName);
    }

    public MutableLiveData<DogImageResponse> getDogImageListLiveData() {
        if (dogImageListLiveData == null) {
            dogImageListLiveData = new MutableLiveData<>();
        }
        return dogImageListLiveData;
    }
}

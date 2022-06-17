package com.example.pixselectcase.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.pixselectcase.entity.DogsResponse;
import com.example.pixselectcase.repository.DogsDaoRepository;


public class MainViewModel extends AndroidViewModel {

    private final DogsDaoRepository dogsDaoRepository;
    private MutableLiveData<DogsResponse> dogListLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        dogsDaoRepository = new DogsDaoRepository();
        loadDogs();
    }

    private void loadDogs() {
        dogsDaoRepository.getAllDogs(getDogListLiveData());
    }

    public MutableLiveData<DogsResponse> getDogListLiveData() {
        if (dogListLiveData == null)
            dogListLiveData = new MutableLiveData<>();
        return dogListLiveData;
    }
}

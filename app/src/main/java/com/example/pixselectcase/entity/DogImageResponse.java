package com.example.pixselectcase.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogImageResponse {
    @SerializedName("message")
    @Expose
    private List<String> breedImages;
    @SerializedName("status")
    @Expose
    private String status;

    public List<String> getBreedImages() {
        return breedImages;
    }

    public void setBreedImages(List<String> breedImages) {
        this.breedImages = breedImages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

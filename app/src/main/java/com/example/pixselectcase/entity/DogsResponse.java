package com.example.pixselectcase.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class DogsResponse {
    @SerializedName("message")
    @Expose
    private Map<String, List<String>> dogsList;
    @SerializedName("status")
    @Expose
    private String status;

    public Map<String, List<String>> getDogsList() {
        return dogsList;
    }

    public void setDogsList(Map<String, List<String>> dogsList) {
        this.dogsList = dogsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

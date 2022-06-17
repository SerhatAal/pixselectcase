package com.example.pixselectcase.ui.fullscreen;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.pixselectcase.R;
import com.example.pixselectcase.databinding.FragmentFullscreenBinding;


public class FullscreenFragment extends DialogFragment {
    private FragmentFullscreenBinding binding;
    private String clickedImageUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFullscreenBinding.inflate(inflater, container, false);

        Glide.with(requireContext())
                .load(clickedImageUrl)
                .placeholder(R.drawable.ic_baseline_image)
                .into(binding.imageViewFullScreen);

        return binding.getRoot();
    }

    public void setData(String breedImageUrl) {
        this.clickedImageUrl = breedImageUrl;
    }
}
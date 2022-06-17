package com.example.pixselectcase.ui.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pixselectcase.databinding.FragmentDetailBinding;
import com.example.pixselectcase.ui.fullscreen.FullscreenFragment;
import com.example.pixselectcase.utils.ImageClickListener;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends Fragment implements ImageClickListener {
    private FragmentDetailBinding binding;
    private DetailViewModel viewModel;
    private DetailAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);

        Bundle bundle = getArguments();
        String breedName = bundle.getString("BreedName");
        viewModel.getBreedImages(breedName);

        binding.recyclerViewDetail.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        viewModel.getDogImageListLiveData().observe(getViewLifecycleOwner(), list -> {
            adapter = new DetailAdapter(requireContext(), list, this);
            binding.recyclerViewDetail.setAdapter(adapter);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
    }

    @Override
    public void onClickData(String imageUrl) {
        FullscreenFragment fragment = new FullscreenFragment();
        fragment.setData(imageUrl);
        fragment.show(getChildFragmentManager(), "FullscreenFragment");
    }
}
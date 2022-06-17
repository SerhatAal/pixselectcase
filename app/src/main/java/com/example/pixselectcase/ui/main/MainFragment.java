package com.example.pixselectcase.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pixselectcase.R;
import com.example.pixselectcase.databinding.FragmentMainBinding;
import com.example.pixselectcase.utils.ClickListener;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment implements ClickListener {
    private FragmentMainBinding binding;
    private MainViewModel viewModel;
    private MainAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        binding.recyclerViewDogBreed.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.getDogListLiveData().observe(getViewLifecycleOwner(), list -> {
            adapter = new MainAdapter(requireContext(), list, this);
            binding.recyclerViewDogBreed.setAdapter(adapter);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void onClickData(String breedName) {
        Bundle bundle = new Bundle();
        bundle.putString("BreedName", breedName);
        Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_detailFragment, bundle);
    }
}
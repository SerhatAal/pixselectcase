package com.example.pixselectcase.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pixselectcase.R;
import com.example.pixselectcase.databinding.CardDogImageBinding;
import com.example.pixselectcase.entity.DogImageResponse;
import com.example.pixselectcase.utils.ImageClickListener;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailCardViewHolder> {
    private final Context mContext;
    private final DogImageResponse dogImageList;
    private final ImageClickListener listener;

    public DetailAdapter(Context mContext, DogImageResponse dogImageList, ImageClickListener listener) {
        this.mContext = mContext;
        this.dogImageList = dogImageList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DetailCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardDogImageBinding binding = CardDogImageBinding.inflate(layoutInflater, parent, false);
        return new DetailCardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailCardViewHolder holder, int position) {
        String breedImageUrl = dogImageList.getBreedImages().get(position);
        Glide.with(mContext)
                .load(breedImageUrl)
                .placeholder(R.drawable.ic_baseline_image)
                .into(holder.binding.imageViewDogBreed);

        holder.binding.imageViewDogBreed.setOnClickListener(view -> {
            listener.onClickData(breedImageUrl);
        });
    }

    @Override
    public int getItemCount() {
        return dogImageList.getBreedImages().size();
    }

    public class DetailCardViewHolder extends RecyclerView.ViewHolder {
        private final CardDogImageBinding binding;

        public DetailCardViewHolder(CardDogImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

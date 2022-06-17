package com.example.pixselectcase.ui.main;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixselectcase.databinding.CardDogListBinding;
import com.example.pixselectcase.entity.DogsResponse;
import com.example.pixselectcase.utils.ClickListener;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CardViewHolder> {
    private final Context mContext;
    private DogsResponse dogList;
    private final ClickListener listener;

    public MainAdapter(Context mContext, DogsResponse dogList, ClickListener listener) {
        this.mContext = mContext;
        this.dogList = dogList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardDogListBinding binding = CardDogListBinding.inflate(layoutInflater, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        String dogBreedName = dogList.getDogsList().keySet().toArray()[position].toString();
        holder.binding.textViewDogBreed.setText(dogBreedName);
        holder.binding.dogCard.setOnClickListener(view -> {
            listener.onClickData(dogBreedName);
        });
    }

    @Override
    public int getItemCount() {
        return dogList.getDogsList().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private final CardDogListBinding binding;

        public CardViewHolder(CardDogListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

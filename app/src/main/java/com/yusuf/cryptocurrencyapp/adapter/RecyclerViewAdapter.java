package com.yusuf.cryptocurrencyapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yusuf.cryptocurrencyapp.dao.Crypto;
import com.yusuf.cryptocurrencyapp.databinding.CryptoRowBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    List<Crypto> cryptos;

    private String[] colors = {"#a3ff00","#ff00aa","#b4a7d6","#a4c2f4","#8ee5ee","#cd950c","#f5f5f5","#f47932"};


    public RecyclerViewAdapter(List<Crypto> cryptos) {
        this.cryptos=cryptos;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CryptoRowBinding binding = CryptoRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.binding.priceView.setBackgroundColor(Color.parseColor(colors[position % 8]));
        holder.binding.currencyView.setBackgroundColor(Color.parseColor(colors[position % 8]));
         holder.binding.currencyView.setText(cryptos.get(position).getCurrency());
            holder.binding.priceView.setText(cryptos.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        System.out.println("***********************************************************"+cryptos.size());
        return cryptos.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        CryptoRowBinding binding;

        public RecyclerViewHolder(@NonNull CryptoRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

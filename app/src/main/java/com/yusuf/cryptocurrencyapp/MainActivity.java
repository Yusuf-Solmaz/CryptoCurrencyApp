package com.yusuf.cryptocurrencyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yusuf.cryptocurrencyapp.adapter.RecyclerViewAdapter;
import com.yusuf.cryptocurrencyapp.dao.Crypto;
import com.yusuf.cryptocurrencyapp.databinding.ActivityMainBinding;
import com.yusuf.cryptocurrencyapp.service.CryptoAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Crypto> cryptoList = new ArrayList<>();
    String BASE_URL = "https://raw.githubusercontent.com/";
    Retrofit retrofit;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        getData();


    }


    private void getData(){
        CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);

        Call<List<Crypto>> cryptos = cryptoAPI.getAll();
        cryptos.enqueue(new Callback<List<Crypto>>() {
            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
                if (response.isSuccessful()){

                    cryptoList = response.body();

                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter = new RecyclerViewAdapter(cryptoList);
                    binding.recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<Crypto>> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });
    }
}
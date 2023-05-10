package com.yusuf.cryptocurrencyapp.service;

import com.yusuf.cryptocurrencyapp.dao.Crypto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    //https://raw.githubusercontent.com/
    // Yusuf-Solmaz/CryptoCurrencyApp/master/cyptoCurrencies.json


    @GET("Yusuf-Solmaz/CryptoCurrencyApp/master/cyptoCurrencies.json")
    Call<List<Crypto>> getAll();


}

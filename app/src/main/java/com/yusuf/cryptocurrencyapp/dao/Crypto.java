package com.yusuf.cryptocurrencyapp.dao;


import com.google.gson.annotations.SerializedName;

public class Crypto {


    @SerializedName("currency")
    String currency;

    @SerializedName("price")
    String price;
}

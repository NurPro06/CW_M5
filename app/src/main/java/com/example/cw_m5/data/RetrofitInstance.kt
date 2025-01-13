package com.example.cw_m5.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .build()

    val api = retrofit.create(LoveApiService::class.java)

}
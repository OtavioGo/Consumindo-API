package com.example.testecepapikotlin.api

import com.example.testecepapikotlin.util.Constants.Companion.BASE_URL_ADVICE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceAdvice {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_ADVICE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleAPI by lazy {
        retrofit.create(SimpleAPI::class.java)
    }
}
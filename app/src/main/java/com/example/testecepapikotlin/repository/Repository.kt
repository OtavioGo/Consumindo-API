package com.example.testecepapikotlin.repository

import com.example.testecepapikotlin.api.RetrofitInstanceAdvice
import com.example.testecepapikotlin.api.RetrofitInstanceCEP
import com.example.testecepapikotlin.api.RetrofitInstanceChuck
import com.example.testecepapikotlin.model.Chuck
import com.example.testecepapikotlin.model.Post
import com.example.testecepapikotlin.model.slip
import retrofit2.Response

class Repository {
    suspend fun getNumberCEP(number: String): Response<Post>{
        return RetrofitInstanceCEP.api.getNumberCEP(number)
    }

    suspend fun getAdvice(): Response<slip>{
        return RetrofitInstanceAdvice.api.getAdvice()
    }

    suspend fun getChuckNorris(): Response<Chuck>{
        return RetrofitInstanceChuck.api.getChuckNorris()
    }
}
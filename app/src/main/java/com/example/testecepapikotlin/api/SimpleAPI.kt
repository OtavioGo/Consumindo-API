package com.example.testecepapikotlin.api

import com.example.testecepapikotlin.model.Chuck
import com.example.testecepapikotlin.model.Post
import com.example.testecepapikotlin.model.slip
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleAPI {
    @GET("ws/{cepNumber}/json/")
    suspend fun getNumberCEP(
        @Path("cepNumber") number: String
    ): Response<Post>

    @GET("advice")
    suspend fun getAdvice(): Response<slip>

    @GET("jokes/random")
    suspend fun getChuckNorris(): Response<Chuck>
}

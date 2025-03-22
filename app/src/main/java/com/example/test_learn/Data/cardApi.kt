package com.example.test_learn.Data

import retrofit2.Response
import retrofit2.http.GET

interface cardApi {
    @GET("robots.json")
    suspend fun getCards(): Response<List<Card>>
}
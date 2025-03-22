package com.example.test_learn.Data

import retrofit2.Response
import retrofit2.http.GET

interface productinterface {
    @GET("olive_oils.json")
    suspend fun getProducts(): Response<List<Products>>
}
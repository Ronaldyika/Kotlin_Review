package com.example.test_learn.Data

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val Base_Url = "https://data/"

class DataRepository(private val context:Context) {
    private val retrofit: Retrofit by lazy {
        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val productinterface : productinterface by lazy {
        retrofit.create(productinterface::class.java)
    }

    suspend fun getproducts():List<Products>{
        val response = productinterface.getProducts()
        return  if (response.isSuccessful)
            response.body().orEmpty()
        else emptyList()
    }


}

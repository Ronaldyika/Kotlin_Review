package com.example.test_learn.Data

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


const val base_url = "https://youcanlearnit.net/robots/0/"

class cardRepository (private val context:Context){
    private val retrofit: Retrofit  by lazy {
        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val cardApi : cardApi by lazy {
        retrofit.create(cardApi::class.java)
    }

    suspend fun getCards():List<Card>{
        val response = cardApi.getCards()
        return  if(response.isSuccessful)
            response.body().orEmpty()
        else emptyList()
    }
}
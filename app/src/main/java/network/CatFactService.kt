package com.example.androidlopputyo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class CatFact(
    val _id: String?,
    val text: String
)

interface CatFactService {
    @GET("facts")
    suspend fun getCatFacts(): List<CatFact>

    companion object {
        private const val BASE_URL = "https://cat-fact.herokuapp.com/"

        fun create(): CatFactService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CatFactService::class.java)
        }
    }
}

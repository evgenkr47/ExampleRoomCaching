package com.example.exampleroomcaching.data.remote

import com.example.exampleroomcaching.data.entity.Pizza
import com.example.exampleroomcaching.data.entity.PizzaResponse
import retrofit2.Response
import retrofit2.http.GET

interface PizzaService {
    @GET(API_KEY)
    suspend fun getPizzaList(): Response<PizzaResponse>

    companion object{
        const val API_KEY = "8aaa4c36d9afdd150144"
        const val BASE_URL = "https://api.npoint.io/"
    }
}
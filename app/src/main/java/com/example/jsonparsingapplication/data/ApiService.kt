package com.example.jsonparsingapplication.data

import com.example.jsonparsingapplication.data.model.FactsDTO
import retrofit2.http.GET

interface ApiService {

    @GET("facts.json")
    suspend fun getFactsList(): FactsDTO
}
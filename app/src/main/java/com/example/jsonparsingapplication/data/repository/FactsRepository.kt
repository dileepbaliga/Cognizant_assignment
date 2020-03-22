package com.example.jsonparsingapplication.data.repository

import com.example.jsonparsingapplication.data.model.FactsDTO

interface FactsRepository {
    suspend fun fetchFactsList() : FactsDTO
}
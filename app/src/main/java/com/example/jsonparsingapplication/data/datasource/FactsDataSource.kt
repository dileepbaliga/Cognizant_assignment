package com.example.jsonparsingapplication.data.datasource

import com.example.jsonparsingapplication.data.model.FactsDTO

interface FactsDataSource {

    suspend fun fetchFactsList() : FactsDTO
}
package com.example.jsonparsingapplication.data.repository

import com.example.jsonparsingapplication.data.datasource.FactsDataSource
import com.example.jsonparsingapplication.data.model.FactsDTO

class FactsRepositoryImpl constructor(var factsDataSource: FactsDataSource) : FactsRepository {
    override suspend fun fetchFactsList() : FactsDTO {
        return factsDataSource.fetchFactsList()
    }
}
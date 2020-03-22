package com.example.jsonparsingapplication.data.datasource

import com.example.jsonparsingapplication.data.ApiService
import com.example.jsonparsingapplication.data.model.FactsDTO

class FactsDataSourceImpl constructor(var apiService: ApiService) : FactsDataSource {
    override suspend fun fetchFactsList() : FactsDTO  {
        return apiService.getFactsList()
    }
}
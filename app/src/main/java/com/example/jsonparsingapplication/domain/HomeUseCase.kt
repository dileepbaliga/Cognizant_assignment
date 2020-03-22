package com.example.jsonparsingapplication.domain

import com.example.jsonparsingapplication.data.ApiErrorHandler
import com.example.jsonparsingapplication.data.model.FactsDTO
import com.example.jsonparsingapplication.data.repository.FactsRepository
import com.example.jsonparsingapplication.domain.usecase.base.UseCase

class HomeUseCase constructor(
    var factsRepository: FactsRepository,
    apiErrorHandler: ApiErrorHandler
) : UseCase<FactsDTO, Any?>(apiErrorHandler) {
    override suspend fun run(params: Any?): FactsDTO {
        return factsRepository.fetchFactsList()
    }
}
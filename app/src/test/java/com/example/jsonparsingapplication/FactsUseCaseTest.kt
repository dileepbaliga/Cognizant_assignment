package com.example.jsonparsingapplication

import com.example.jsonparsingapplication.data.model.ErrorModel
import com.example.jsonparsingapplication.data.model.FactsDTO
import com.example.jsonparsingapplication.data.repository.FactsRepository
import com.example.jsonparsingapplication.domain.HomeUseCase
import com.example.jsonparsingapplication.domain.usecase.base.UseCaseResponse
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class FactsUseCaseTest {


    @Test
    fun when_receive_valid_response() {
        val factsRepository = mock<FactsRepository>()
        val homeUseCase = HomeUseCase(factsRepository,null)
        val factsResponse = createFactResponse()
        runBlocking {

            whenever(factsRepository.fetchFactsList()).thenReturn(
                factsResponse
            )
            factsRepository.fetchFactsList()
            homeUseCase.invoke(GlobalScope,null,object :UseCaseResponse<FactsDTO> {
                override fun onError(errorModel: ErrorModel?) {

                }

                override fun onSuccess(result: FactsDTO) {
                    Assert.assertEquals("About Canada", result.title)
                }

            })
        }
    }

    private fun createFactResponse(): FactsDTO {
        return FactsDTO("About Canada", emptyList())
    }
}
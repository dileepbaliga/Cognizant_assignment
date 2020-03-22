package com.example.jsonparsingapplication.domain.usecase.base

import com.example.jsonparsingapplication.data.model.ErrorModel

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(errorModel: ErrorModel?)
}


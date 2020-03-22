package com.example.jsonparsingapplication.domain.usecase.base

import com.example.jsonparsingapplication.data.ApiErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException

abstract class UseCase<Type, in Params>(private val apiErrorHandler: ApiErrorHandler?) where Type : Any {

    abstract suspend fun run(params: Params? = null): Type

    fun invoke(
        scope: CoroutineScope,
        params: Params?,
        onResult: (UseCaseResponse<Type>)
    ) {
        val backgroundJob = scope.async { run(params) }
        scope.launch {
            backgroundJob.await().let {
                try {
                    onResult.onSuccess(it)
                } catch (e: HttpException) {
                    //onResult.onError(apiErrorHandler?.traceErrorException(e))
                }
            }
        }
    }
}
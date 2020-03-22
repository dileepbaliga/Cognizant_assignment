package com.example.jsonparsingapplication.data

import com.example.jsonparsingapplication.data.model.ErrorModel
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * This class trace exceptions(api call or parse data or connection errors) &
 * depending on what exception returns a [ErrorModel]
 *
 * */
class ApiErrorHandler {

    fun traceErrorException(throwable: Throwable?): ErrorModel {
        val errorModel: ErrorModel? = when (throwable) {
            // handle api call timeout error
            is SocketTimeoutException -> {
                ErrorModel(throwable.message, ErrorModel.ErrorStatus.TIMEOUT)
            }

            // handle connection error
            is IOException -> {
                ErrorModel(throwable.message, ErrorModel.ErrorStatus.NO_CONNECTION)
            }
            else -> {
                ErrorModel(throwable?.message, ErrorModel.ErrorStatus.UNAUTHORIZED)

            }
        }
        return errorModel ?: ErrorModel("No Defined Error!", 0, ErrorModel.ErrorStatus.BAD_RESPONSE)
    }
}
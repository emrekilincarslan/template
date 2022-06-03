package com.scalefocus.base_service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scalefocus.base_service.NetworkErrors.NETWORK_ERROR_UNKNOWN
import com.scalefocus.base_service.common.ErrorObject
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

suspend fun <T> handleApiCall(
    apiCall: suspend () -> T
): KfnResult<T> {
    return try {
        val value = apiCall.invoke()

        @Suppress("UNCHECKED_CAST")
        if ((value as? Response<Unit>) != null) {
            if (!value.isSuccessful) {
                throw HttpException(value)
            }
        }

        KfnResult.Success(value)
    } catch (throwable: Throwable) {
        throwable.printStackTrace()

        when (throwable) {
            is HttpException -> {
                val code = throwable.code()
                val errorResponse = convertErrorBody(throwable)

                Timber.e(errorResponse)

                KfnResult.GenericError(
                    code,
                    errorResponse
                )
            }
            else -> {
                Timber.e(throwable)
                KfnResult.GenericError(
                    null,
                    NETWORK_ERROR_UNKNOWN
                )
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): String {
    return try {
        val gson = Gson()
        val type = object : TypeToken<ErrorObject>() {}.type
        val errorObject: ErrorObject? =
            gson.fromJson(throwable.response()?.errorBody()?.string(), type)
        return errorObject?.external?.message ?: GenericErrors.ERROR_UNKNOWN
    } catch (exception: Exception) {
        GenericErrors.ERROR_UNKNOWN
    }
}

object GenericErrors {
    const val ERROR_UNKNOWN = "Unknown error"
}
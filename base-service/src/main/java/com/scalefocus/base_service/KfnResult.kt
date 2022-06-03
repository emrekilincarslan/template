package com.scalefocus.base_service

sealed class KfnResult<out T> {
    data class Success<out T>(val value: T) : KfnResult<T>()

    data class GenericError(
        val code: Int? = null,
        val errorMessage: String? = null
    ) : KfnResult<Nothing>()
}
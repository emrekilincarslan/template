package com.scalefocus.base_service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

inline fun <T> Flow<KfnResult<T>>.doOnSuccess(crossinline action: (T) -> Unit): Flow<KfnResult<T>> =
    flow {
        collect {
            if (it is KfnResult.Success<T>) {
                action.invoke(it.value)
            }

            emit(it)
        }
    }

inline fun <T, R> Flow<KfnResult<T>>.mapSuccess(crossinline convert: (T) -> R): Flow<KfnResult<R>> =
    transform {
        if (it is KfnResult.Success) {
            emit(KfnResult.Success(convert(it.value)))
        } else {
            emit(it as KfnResult<R>)
        }
    }

suspend inline fun <T> Flow<KfnResult<T>>.collect(
    crossinline onSuccess: suspend (T) -> Unit,
    crossinline onFailure: suspend (KfnResult.GenericError) -> Unit
) {
    collect {
        if (it is KfnResult.Success) {
            onSuccess(it.value)
        } else if (it is KfnResult.GenericError) {
            onFailure(it)
        }
    }
}
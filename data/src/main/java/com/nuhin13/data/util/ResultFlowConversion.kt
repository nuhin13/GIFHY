package com.nuhin13.data.util

import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import retrofit2.Response

fun <T> toResultFlow(call: suspend () -> Response<T>?): Flow<DataResult<T>?> {
    return flow {
        emit(DataResult.Loading(null, true))
        val c = call()
        c?.let {
            try {
                if (c.isSuccessful && c.body() != null) {
                    c.body()?.let {
                        emit(DataResult.Success(it))
                    }
                } else {
                    c.errorBody()?.let {
                        emit(DataResult.Error(it.string()))
                    }
                }
            } catch (e: Exception) {
                emit(DataResult.Error(e.toString()))
            }
        }
    }.flowOn(Dispatchers.IO)
}

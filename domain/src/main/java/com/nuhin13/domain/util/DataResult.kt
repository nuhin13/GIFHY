package com.nuhin13.domain.util

enum class DataStatus {
    SUCCESS,
    ERROR,
    LOADING
}

sealed class DataResult<out T>(val status: DataStatus, val data: T?, val message: String?) {
    data class Success<out R>(val innerData: R?) : DataResult<R>(
        status = DataStatus.SUCCESS,
        data = innerData,
        message = null
    )

    data class Error(val exception: String) : DataResult<Nothing>(
        status = DataStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<out R>(val innerData: R?, val isLoading: Boolean) : DataResult<R>(
        status = DataStatus.LOADING,
        data = innerData,
        message = null
    )
}
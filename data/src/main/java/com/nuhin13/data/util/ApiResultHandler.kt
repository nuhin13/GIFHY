package com.nuhin13.data.util

import androidx.lifecycle.MutableLiveData
import com.nuhin13.domain.util.DataResult
import com.nuhin13.domain.util.DataStatus

class ApiResultHandler<T>(
    private val onSuccess: (T?) -> Unit,
    private val onFailure: (T?) -> Unit
) {

    private var loading = MutableLiveData<Boolean>()
    fun handleApiResult(result: DataResult<T?>) {
        when (result.status) {
            DataStatus.LOADING -> {
                loading.value = true
            }

            DataStatus.SUCCESS -> {
                loading.value = false
                onSuccess(result.data)
            }

            DataStatus.ERROR -> {
                loading.value = false
                onFailure(result.data)
            }
        }
    }
}

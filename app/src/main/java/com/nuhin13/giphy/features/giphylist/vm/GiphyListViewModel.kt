package com.nuhin13.giphy.features.giphylist.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.usecase.GetGiphyListBySearch
import com.nuhin13.domain.util.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class GiphyListStatus {
    INITIAL,
    LOADING,
    SUCCESS,
    ERROR,
    NO_DATA
}

@HiltViewModel
class GiphyListViewModel @Inject constructor(private val getGiphyList: GetGiphyListBySearch) :
    ViewModel() {

    data class GiphyListUiState(
        val status: GiphyListStatus = GiphyListStatus.INITIAL,
        val statusMessage: String = "Please enter a search query",
        val giphyList: GiphyList = GiphyList(data = arrayListOf())
    )

    private val _uiState: MutableStateFlow<GiphyListUiState> = MutableStateFlow(GiphyListUiState())
    val uiState = _uiState.asStateFlow()

    fun getGiphyList(query: String) {
        if (query.isEmpty()) {
            updateGiphyList(
                GiphyListStatus.INITIAL,
                message = "Please enter a search query"
            )
            return
        }

        viewModelScope.launch {
            try {
                getGiphyList.getSearchGiphyList(query, 25).collect {
                    when (it.status) {
                        DataStatus.LOADING -> updateGiphyList(
                            GiphyListStatus.LOADING, "Loading..."
                        )

                        DataStatus.ERROR -> updateGiphyList(GiphyListStatus.NO_DATA, it.message)

                        DataStatus.SUCCESS -> updateGiphyList(
                            GiphyListStatus.SUCCESS,
                            it.message,
                            it.data
                        )
                    }

                }
            } catch (e: Exception) {
                e.printStackTrace()
                updateGiphyList(GiphyListStatus.ERROR)
            }
        }
    }

    private fun updateGiphyList(
        status: GiphyListStatus, message: String? = null,
        giphyList: GiphyList? = null
    ) {
        _uiState.value = GiphyListUiState(
            status,
            message ?: "Something went wrong",
            giphyList ?: GiphyList(arrayListOf())
        )
    }
}
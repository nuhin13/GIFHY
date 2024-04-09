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

@HiltViewModel
class GiphyListViewModel @Inject constructor(private val getGiphyList: GetGiphyListBySearch) : ViewModel() {

    data class GiphyListUiState(
        val status: DataStatus = DataStatus.LOADING,
        val giphyList: GiphyList = GiphyList(data = arrayListOf())
    )

    private val _uiState: MutableStateFlow<GiphyListUiState> = MutableStateFlow(GiphyListUiState())
    val uiState = _uiState.asStateFlow()

    fun getGiphyList(query: String) {
        viewModelScope.launch {
            try {
                val results =  getGiphyList.getSearchGiphyList(query, 25)

                _uiState.value = _uiState.value.copy(giphyList = results)



//                getGiphyList.getSearchGiphyList("bugi").data.collect {
//                    _uiState.value = GiphyListUiState(
//                        DataStatus.SUCCESS,
//                        GiphyList(arrayListOf())
//                    )
//                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
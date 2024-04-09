package com.nuhin13.giphy.features.giphylist.presentaion

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.nuhin13.giphy.R
import com.nuhin13.giphy.features.giphylist.vm.GiphyListStatus
import com.nuhin13.giphy.features.giphylist.vm.GiphyListViewModel

@Composable
fun GiphyListScreen(giphyListViewModel: GiphyListViewModel) {

    val state = giphyListViewModel.uiState.collectAsState()


    Column {
        SearchViewWithDebounce(giphyListViewModel)

        when (state.value.status) {

            GiphyListStatus.INITIAL -> {
                GiphyCommonItem(
                    resId = R.drawable.baseline_content_paste_search_24,
                    message = state.value.statusMessage
                )
            }
            GiphyListStatus.LOADING -> {
                GiphyShimmerItem()
            }
            GiphyListStatus.SUCCESS -> {
                GiphyListItem(giphyListViewModel)
            }
            GiphyListStatus.ERROR -> {
                GiphyCommonItem(
                    resId = R.drawable.baseline_search_off_24,
                    message = state.value.statusMessage
                )
            }
            GiphyListStatus.NO_DATA -> GiphyCommonItem(
                resId = R.drawable.baseline_report_gmailerrorred_24,
                message = state.value.statusMessage
            )
        }
    }
}


@Preview
@Composable
fun GiphyListScreenPreview() {
    //ShimmerAnimation()
    //ErrorScreen()
    //GiphyListScreen(giphyListViewModel = hiltViewModel())
}

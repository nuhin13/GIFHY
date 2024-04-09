package com.nuhin13.giphy.features.giphylist.presentaion

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.nuhin13.giphy.features.giphylist.vm.GiphyListViewModel

@Composable
fun GiphyListScreen(giphyListViewModel: GiphyListViewModel) {

    val state = giphyListViewModel.uiState.collectAsState()
    val itemsList = state.value.giphyList.data

    Column {
        SearchViewWithDebounce(giphyListViewModel)

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp, end = 16.dp),
            verticalItemSpacing = 12.dp,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
            content = {
                items(itemsList.size, key = { itemsList[it].id }) { item ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(itemsList[item].images ?: "")
                            .decoderFactory(
                                if (SDK_INT >= Build.VERSION_CODES.P)
                                    ImageDecoderDecoder.Factory()
                                else GifDecoder.Factory()
                            )
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        )

    }
}

@Preview
@Composable
fun GiphyListScreenPreview() {
    GiphyListScreen(giphyListViewModel = hiltViewModel())
}

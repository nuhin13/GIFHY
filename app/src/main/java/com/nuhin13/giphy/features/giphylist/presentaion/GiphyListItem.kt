package com.nuhin13.giphy.features.giphylist.presentaion

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.nuhin13.giphy.features.giphylist.vm.GiphyListViewModel

@Composable
fun GiphyListItem(giphyListViewModel: GiphyListViewModel) {

    val state = giphyListViewModel.uiState.collectAsState()
    val itemsList = state.value.giphyList.data

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        verticalItemSpacing = 12.dp,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 8.dp),
        content = {
            items(itemsList.size, key = { itemsList[it].id }) { item ->

                Box {
                    GifImage(url = itemsList[item].images ?: "")

                    AsyncImage(
                        model = itemsList[item].user?.profileImage,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .align(Alignment.TopEnd),
                        contentScale = ContentScale.Fit,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun GifImage(url: String) {
    val showShimmer = remember { mutableStateOf(true) }

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .decoderFactory(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
                    ImageDecoderDecoder.Factory()
                else GifDecoder.Factory()
            ).build(),
        contentDescription = null,
        modifier = Modifier
            .background(
                itemShimmerBrush(
                    targetValue = 1300f,
                    showShimmer = showShimmer.value
                )
            )
            .width(250.dp)
            .heightIn(min = 220.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        onSuccess = { showShimmer.value = false },
        contentScale = ContentScale.Crop
    )
}


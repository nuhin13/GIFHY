package com.nuhin13.data.features.gifhy_search.dtos

data class ImagesReponse(
    val `480w_still`: ImageInfoObject,
    val `4k`: ImageInfoObject,
    val downsized: ImageInfoObject,
    val downsized_large: ImageInfoObject,
    val downsized_medium: ImageInfoObject,
    val downsized_small: ImageInfoObject,
    val downsized_still: ImageInfoObject,
    val fixed_height: ImageInfoObject,
    val fixed_height_downsampled: ImageInfoObject,
    val fixed_height_small: ImageInfoObject,
    val fixed_height_small_still: ImageInfoObject,
    val fixed_height_still: ImageInfoObject,
    val fixed_width: ImageInfoObject,
    val fixed_width_downsampled: ImageInfoObject,
    val fixed_width_small: ImageInfoObject,
    val fixed_width_small_still: ImageInfoObject,
    val fixed_width_still: ImageInfoObject,
    val hd: ImageInfoObject,
    val looping: ImageInfoObject,
    val original: ImageInfoObject,
    val original_mp4: ImageInfoObject,
    val original_still: ImageInfoObject,
    val preview: ImageInfoObject,
    val preview_gif: ImageInfoObject,
    val preview_webp: ImageInfoObject
)

data class ImageInfoObject (
    val frames: String?,
    val hash: String?,
    val height: String?,
    val mp4: String?,
    val mp4_size: String?,
    val size: String?,
    val url: String?,
    val webp: String?,
    val webp_size: String?,
    val width: String?
)
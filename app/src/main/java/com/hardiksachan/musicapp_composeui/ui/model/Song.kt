package com.hardiksachan.musicapp_composeui.ui.model

import androidx.annotation.DrawableRes

data class Song(
    val name: String,
    val artist: String,
    @DrawableRes val image: Int,
)

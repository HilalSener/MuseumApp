package com.hilal.museumapp.data.remote.models

import com.squareup.moshi.Json

data class ArtworkResponse(
    @Json(name = "artObject")
    val artwork: Artwork
)
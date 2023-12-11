package com.hilal.museumapp.data.remote.models

import com.squareup.moshi.Json

data class Image(
    @Json(name = "url")
    val url: String?
)

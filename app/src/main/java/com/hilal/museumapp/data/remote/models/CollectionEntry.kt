package com.hilal.museumapp.data.remote.models

import com.squareup.moshi.Json

data class CollectionEntry(
    @Json(name = "objectNumber")
    val identifier: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "webImage")
    val image: Image?,
    @Json(name = "principalOrFirstMaker")
    val primaryAuthor: String
)
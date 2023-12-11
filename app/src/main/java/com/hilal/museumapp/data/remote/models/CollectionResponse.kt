package com.hilal.museumapp.data.remote.models

import com.squareup.moshi.Json

data class CollectionResponse(
    @Json(name = "artObjects")
    val collectionEntries: List<CollectionEntry>
)
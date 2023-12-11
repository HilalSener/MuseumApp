package com.hilal.museumapp.models

data class CollectionEntry(
    val identifier: String,
    val title: String,
    val imageUrl: String?,
    val primaryAuthor: String
)
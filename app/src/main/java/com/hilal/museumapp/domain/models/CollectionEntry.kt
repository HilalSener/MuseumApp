package com.hilal.museumapp.domain.models

data class CollectionEntry(
    val identifier: String,
    val title: String,
    val imageUrl: String?,
    val primaryAuthor: String
)
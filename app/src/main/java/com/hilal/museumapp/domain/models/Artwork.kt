package com.hilal.museumapp.domain.models

data class Artwork(
    val identifier: String,
    val title: String,
    val subtitle: String,
    val description: String?,
    val imageUrl: String?,
    val physicalMedium: String,
)
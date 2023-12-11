package com.hilal.museumapp.repository.conversions

import com.hilal.museumapp.domain.models.Artwork
import com.hilal.museumapp.data.remote.models.Artwork as RemoteArtwork

fun RemoteArtwork.toDomain(): Artwork =
    Artwork(
        identifier,
        title,
        subtitle,
        description,
        image?.url,
        physicalMedium
    )
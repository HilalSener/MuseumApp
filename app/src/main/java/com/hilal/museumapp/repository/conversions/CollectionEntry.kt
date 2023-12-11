package com.hilal.museumapp.repository.conversions

import com.hilal.museumapp.domain.models.CollectionEntry
import com.hilal.museumapp.data.remote.models.CollectionEntry as RemoteCollectionEntry

fun RemoteCollectionEntry.toDomain(): CollectionEntry = CollectionEntry(
    identifier,
    title,
    image?.url,
    primaryAuthor
)
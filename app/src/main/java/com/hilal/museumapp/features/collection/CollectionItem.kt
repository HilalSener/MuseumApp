package com.hilal.museumapp.features.collection

import com.hilal.museumapp.domain.models.CollectionEntry

sealed class CollectionItem

data class AuthorNameItem(val name: String): CollectionItem()
data class CollectionEntryItem(val collectionEntry: CollectionEntry): CollectionItem()
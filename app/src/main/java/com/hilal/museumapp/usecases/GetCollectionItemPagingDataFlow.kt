package com.hilal.museumapp.usecases

import androidx.paging.*
import com.hilal.museumapp.features.collection.AuthorNameItem
import com.hilal.museumapp.features.collection.CollectionEntryItem
import com.hilal.museumapp.features.collection.CollectionItem
import com.hilal.museumapp.repository.CollectionEntryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCollectionItemPagingDataFlow @Inject constructor(private val collectionEntryRepository: CollectionEntryRepository) {

    operator fun invoke(): Flow<PagingData<CollectionItem>> =
        collectionEntryRepository.getCollectionEntryPager()
            .flow
            .map {
                val modifiedPagingData: PagingData<CollectionItem> = it.map { entry ->
                    CollectionEntryItem(entry)
                }
                modifiedPagingData.insertSeparators { previousItem: CollectionItem?,
                                                      nextItem: CollectionItem? ->
                    val previousCollectionItem =
                        previousItem as? CollectionEntryItem
                    val nextCollectionItem = nextItem as? CollectionEntryItem
                    val previousAuthor = previousCollectionItem?.collectionEntry?.primaryAuthor
                    val nextAuthor =
                        nextCollectionItem?.collectionEntry?.primaryAuthor ?: return@insertSeparators null
                    return@insertSeparators if (previousAuthor != nextAuthor) {
                        AuthorNameItem(nextAuthor)
                    } else {
                        null
                    }
                }
            }
}
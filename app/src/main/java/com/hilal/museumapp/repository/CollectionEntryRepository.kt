package com.hilal.museumapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.hilal.museumapp.repository.paging.CollectionEntryPagingSource
import com.hilal.museumapp.data.remote.MuseumApi
import javax.inject.Inject

class CollectionEntryRepository @Inject constructor(private val museumApi: MuseumApi) {
   private val pagingConfig = PagingConfig(pageSize = 10)

   fun getCollectionEntryPager() = Pager(
      config = pagingConfig,
      pagingSourceFactory = { CollectionEntryPagingSource(museumApi) }
   )
}
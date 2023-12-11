package com.hilal.museumapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.hilal.museumapp.repository.paging.CollectionEntryPagingSource
import com.hilal.museumapp.data.remote.MuseumApi

class CollectionEntryRepository(private val museumApi: MuseumApi) {
   private val pagingConfig = PagingConfig(pageSize = 10)

   fun getCollectionEntryPager() = Pager(
      config = pagingConfig,
      pagingSourceFactory = { CollectionEntryPagingSource(museumApi) }
   )
}
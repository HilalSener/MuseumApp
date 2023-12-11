package com.hilal.museumapp.features.collection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hilal.museumapp.usecases.GetCollectionItemPagingDataFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    getCollectionItemPagingDataFlow: GetCollectionItemPagingDataFlow
) : ViewModel() {
    val collectionItemPagingDataFlow = getCollectionItemPagingDataFlow()
        .cachedIn(viewModelScope)
}
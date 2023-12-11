package com.hilal.museumapp.features.collection

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hilal.museumapp.domain.models.CollectionEntry
import com.hilal.museumapp.features.BaseComposableFragment

@AndroidEntryPoint
class CollectionFragment : BaseComposableFragment() {

    private val viewModel: CollectionViewModel by viewModels()

    @Composable
    override fun ComposeContent() {
        val collectionItem = viewModel.collectionItemPagingDataFlow.collectAsLazyPagingItems()

        CollectionScreen(collectionItems = collectionItem, onItemClick = ::navigateToArtWork)
    }

    private fun navigateToArtWork(collectionEntry: CollectionEntry) {
        findNavController()
            .navigate(CollectionFragmentDirections.actionCollectionFragmentToArtworkFragment(collectionEntry.identifier))
    }
}
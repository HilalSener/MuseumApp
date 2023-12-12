package com.hilal.museumapp.features.collection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.hilal.museumapp.domain.models.CollectionEntry
import com.hilal.museumapp.features.compose.components.CollectionEntryView
import com.hilal.museumapp.features.compose.components.LoadingIndicator

@Composable
fun CollectionScreen(
    collectionItems: LazyPagingItems<CollectionItem>,
    onItemClick: (CollectionEntry) -> Unit
) {
    when (collectionItems.loadState.refresh) {
        LoadState.Loading -> {
            LoadingIndicator()
        }
        is LoadState.Error -> {
            // TODO: Implement error state
        }
        else -> {
            LazyColumn {
                var currentAuthorName: String? = null
                itemsIndexed(collectionItems) { index, item ->
                    when (item) {
                        is AuthorNameItem -> {
                            currentAuthorName = item.name
                            if (currentAuthorName != null) {
                                // Display the author's name as a header
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Text(
                                        text = currentAuthorName!!,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                        is CollectionEntryItem -> {
                            val collectionEntry = item.collectionEntry
                            Column(
                                modifier = Modifier
                                    .clickable {
                                        // Call the onClick lambda when this Composable is clicked
                                        onItemClick(collectionEntry)
                                    }
                            ) {
                                CollectionEntryView(item = collectionEntry)
                            }
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}

package com.hilal.museumapp.features.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.hilal.museumapp.domain.models.CollectionEntry

@Composable
fun CollectionEntryView(item: CollectionEntry) {
    Row(Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = item.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                    scale(Scale.FILL)
                    transformations(CircleCropTransformation())
                }).build()
            ),
            contentDescription = "Artist image",
            modifier = Modifier.size(80.dp, 80.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Column {
            Text(text = item.identifier, fontSize = 20.sp)
            Text(text = item.title, fontSize = 14.sp)
        }
    }
}


@Composable
@Preview
fun CollectionEntryViewPreview() {
    CollectionEntryView(
        item = CollectionEntry(
            "Very important art",
            "Android Gang",
            "https://foozawebtech.com/assets/images/blog/GettyImages-458243847.jpg",
            "Hilal Sener",)
    )
}


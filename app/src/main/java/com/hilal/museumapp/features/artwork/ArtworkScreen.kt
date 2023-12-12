package com.hilal.museumapp.features.artwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.hilal.museumapp.domain.models.Artwork

@Composable
fun ArtworkScreen(item: Artwork) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
             painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = item.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        scale(Scale.FILL)
                    }).build()
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.description!!,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun ArtworkScreenPreview() {
    ArtworkScreen(item =
    Artwork(
        identifier = "Lorem ipsum",
        title = "Important Art",
        imageUrl = "https://ih1.redbubble.net/image.5031671481.8882/flat,750x,075,f-pad,750x1000,f8f8f8.u3.jpg",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        subtitle = "Lorem ipsum",
        physicalMedium = "Lorem Ipsum"))
}

package com.hilal.museumapp.usecases

import com.hilal.museumapp.repository.ArtworkRepository
import javax.inject.Inject

class GetArtwork @Inject constructor(private val artworkRepository: ArtworkRepository) {

    suspend operator fun invoke(identifier: String) =
        artworkRepository.getArtwork(identifier)
}
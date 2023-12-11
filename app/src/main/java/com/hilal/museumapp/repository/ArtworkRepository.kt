package com.hilal.museumapp.repository

import com.hilal.museumapp.repository.conversions.toDomain
import com.hilal.museumapp.data.remote.MuseumApi

class ArtworkRepository(private val museumApi: MuseumApi) {

    suspend fun getArtwork(identifier: String) =
        museumApi.artwork(identifier).artwork.toDomain()
}
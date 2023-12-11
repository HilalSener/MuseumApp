package com.hilal.museumapp.repository

import com.hilal.museumapp.repository.conversions.toDomain
import com.hilal.museumapp.data.remote.MuseumApi
import javax.inject.Inject

class ArtworkRepository @Inject constructor(private val museumApi: MuseumApi) {

    suspend fun getArtwork(identifier: String) =
        museumApi.artwork(identifier).artwork.toDomain()
}
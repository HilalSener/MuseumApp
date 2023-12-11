package com.hilal.museumapp.data.remote

import com.hilal.museumapp.data.remote.RemoteDataSettings.PAGE_INDEX
import com.hilal.museumapp.data.remote.RemoteDataSettings.PAGE_SIZE
import com.hilal.museumapp.data.remote.models.ArtworkResponse
import com.hilal.museumapp.data.remote.models.CollectionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MuseumApi {
    @GET("nl/collection?imgonly=true&toppieces=true&s=artist")
    suspend fun collection(
        @Query(PAGE_INDEX) pageIndex: Int,
        @Query(PAGE_SIZE) pageSize: Int
    ): CollectionResponse

    @GET("nl/collection/{identifier}")
    suspend fun artwork(
        @Path("identifier") identifier: String,
    ): ArtworkResponse
}
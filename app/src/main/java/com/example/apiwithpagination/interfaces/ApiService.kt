package com.example.apiwithpagination.interfaces

import com.example.apiwithpagination.model.Artists
import com.example.apiwithpagination.model.ArtistsItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("artists")
    suspend fun getArtists(@Query("page") page: Int): List<ArtistsItem>
}
package com.example.apiwithpagination.model

data class ArtistsItem(
    val bio: String,
    val country: String,
    val genres: List<String>,
    val id: Int,
    val image: String,
    val listens: Int,
    val name: String,
    val yearsActive: Int
)
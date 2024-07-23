package com.example.apiwithpagination.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiwithpagination.model.Artists
import com.example.apiwithpagination.model.ArtistsItem
import com.example.apiwithpagination.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api
    val artists: MutableState<List<ArtistsItem>> =
        mutableStateOf(emptyList())

    fun getArtists(page: Int) {
        viewModelScope.launch {
            try {
                val response = apiService.getArtists(page)
                if (response.isNotEmpty()) {
                    artists.value = response
                }
            } catch (e: Exception) {
                // Handle errors here
                e.printStackTrace()
            }
        }
    }
}
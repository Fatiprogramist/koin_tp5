package com.example.tp4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp4.repository.PostRepository

class PostsViewModelFactory(private val repository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

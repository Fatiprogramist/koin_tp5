package com.example.tp4.model.post.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp4.model.post.Post
import com.example.tp4.model.post.room.PostRepository
import kotlinx.coroutines.launch

class PostsViewModel(private val repository: PostRepository) : ViewModel() {

    // LiveData for observing posts
    val allPosts: LiveData<List<Post>> = repository.getPosts()

    // Function to delete all posts
    fun deleteAllPosts() {
        viewModelScope.launch {
            repository.deleteAll()// Implement this method in your repository
        }
    }

}

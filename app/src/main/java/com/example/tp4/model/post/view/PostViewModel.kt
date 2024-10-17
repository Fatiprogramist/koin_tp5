package com.example.tp4.model.post.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp4.model.post.Post
import com.example.tp4.model.post.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    val allPosts: LiveData<List<Post>> = repository.allPosts

    fun insertPosts(posts: List<Post>) {
        viewModelScope.launch {
            posts.forEach { post ->
                repository.insert(post)
            }
        }
    }

    fun deleteAllPosts() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}

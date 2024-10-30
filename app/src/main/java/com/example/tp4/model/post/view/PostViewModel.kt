package com.example.tp4.model.post.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp4.model.post.Post
import com.example.tp4.model.post.room.PostDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostsViewModel(
    private val postDao: PostDao
) : ViewModel() {

    val allPosts: LiveData<List<Post>> = postDao.getAllPosts()

    fun insertPosts(posts: List<Post>) {
        viewModelScope.launch(Dispatchers.IO) {
            postDao.insertPosts(posts)
        }
    }

    fun deleteAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            postDao.deleteAllPosts()
        }
    }
}

package com.example.tp4.model.post.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp4.model.post.Post
import com.example.tp4.model.post.room.PostDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postDao: PostDao
) : ViewModel() {

    val allPosts: LiveData<List<Post>> = postDao.getAllPosts()

    fun insertPosts(posts: List<Post>) {
        viewModelScope.launch {
            posts.forEach { post ->
                postDao.insertPost(post)
            }
        }
    }

    fun deleteAllPosts() {
        viewModelScope.launch {
            postDao.deleteAllPosts()
        }
    }
}

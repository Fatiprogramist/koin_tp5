package com.example.tp4.model.post

import androidx.lifecycle.LiveData
import com.example.tp4.model.post.room.PostDao
import javax.inject.Inject

class PostRepository @Inject constructor(private val postDao: PostDao) {

    val allPosts: LiveData<List<Post>> = postDao.getAllPosts() // Ensure LiveData is fetched here

    // Insert a single post
    suspend fun insert(post: Post) {
        postDao.insertPost(post) // Ensure this is a suspend function in your DAO
    }

    // Optional: Insert multiple posts at once
    suspend fun insert(posts: List<Post>) {
        postDao.insertPosts(posts) // Ensure this is a suspend function in your DAO
    }

    suspend fun deleteAll() {
        postDao.deleteAllPosts() // Ensure this is a suspend function in your DAO
    }
}

package com.example.tp4.repository

import androidx.lifecycle.LiveData
import com.example.tp4.database.PostDao
import com.example.tp4.model.post.Post

class PostRepository(private val postDao: PostDao) {

    val allPosts: LiveData<List<Post>> = postDao.getAllPosts()

    suspend fun insert(post: Post) {
        postDao.insertPost(post)
    }

    suspend fun update(post: Post) {
        postDao.updatePost(post)
    }

    suspend fun delete(post: Post) {
        postDao.deletePost(post)
    }

    suspend fun deleteAll() {
        postDao.deleteAllPosts()
    }
}

package com.example.tp4.model.post.room

import androidx.lifecycle.LiveData
import com.example.tp4.model.post.Post
import javax.inject.Inject

class PostRepository @Inject constructor(private val postDao: PostDao) {

    fun getPosts(): LiveData<List<Post>> {
        return postDao.getAllPosts()
    }

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

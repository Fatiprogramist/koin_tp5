package com.example.tp4.model.post.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tp4.model.post.Post

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<Post>)

    @Query("SELECT * FROM posts")
    fun getAllPosts(): LiveData<List<Post>>

    // Ensure this method returns a nullable Post
    @Query("SELECT * FROM posts WHERE id = :postId")
    fun getPostById(postId: Int): Post?  // Changed to return Post?

    @Update
    fun updatePost(post: Post)

    @Delete
    fun deletePost(post: Post)

    @Query("DELETE FROM posts")
    fun deleteAllPosts()
}

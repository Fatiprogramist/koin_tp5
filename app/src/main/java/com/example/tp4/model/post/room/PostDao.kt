package com.example.tp4.model.post.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tp4.model.post.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post) // Utilisez suspend pour les opérations longues

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<Post>) // Utilisez suspend pour les opérations longues

    @Query("SELECT * FROM posts")
    fun getAllPosts(): LiveData<List<Post>> // LiveData pour observer les changements

    @Query("SELECT * FROM posts WHERE id = :postId")
    fun getPostById(postId: Int): Post? // Retournez Post? pour les résultats potentiellement null

    @Update
    fun updatePost(post: Post) // Utilisez suspend pour les opérations longues

    @Delete
   fun deletePost(post: Post) // Utilisez suspend pour les opérations longues

    @Query("DELETE FROM posts")
    fun deleteAllPosts() // Utilisez suspend pour les opérations longues
}

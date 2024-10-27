package com.example.tp4.model.post.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp4.model.post.Post

@Database(entities = [Post::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}

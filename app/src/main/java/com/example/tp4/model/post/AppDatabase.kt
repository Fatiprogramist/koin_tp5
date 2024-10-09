package com.example.tp4.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp4.model.post.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}

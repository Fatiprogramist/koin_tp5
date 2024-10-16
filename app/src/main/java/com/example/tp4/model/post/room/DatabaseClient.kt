package com.example.tp4.model.post.room

import android.content.Context
import androidx.room.Room

object DatabaseClient {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "PostDB"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}

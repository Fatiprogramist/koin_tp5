package com.example.tp4.model.post.room

import androidx.room.Room
import com.example.tp4.model.post.view.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "post_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().postDao() }
}

package com.example.tp4.model.post.view
import android.content.Context
import androidx.room.Room
import com.example.tp4.model.post.room.AppDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { provideAppDatabase(get()) }
    single { get<AppDatabase>().postDao() }
    viewModel { PostsViewModel(get()) }
}

fun provideAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "post_database"
    )
        .fallbackToDestructiveMigration()
        .build()
}

package com.example.tp4.model.post.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule { // Change class to object

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/" // Use const for a constant

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder() // Return the instance
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

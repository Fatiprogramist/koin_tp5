package com.example.tp4.model.post.retrofit

import com.example.tp4.model.post.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>> // Use 'fun' instead of 'Call'
}

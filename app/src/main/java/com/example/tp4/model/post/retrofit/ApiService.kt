package com.example.tp4.model.post.retrofit;

import com.example.tp4.model.post.Post;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getPosts();
}

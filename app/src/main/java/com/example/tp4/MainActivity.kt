package com.example.tp4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tp4.model.post.retrofit.ApiService
import com.example.tp4.model.post.Post
import com.example.tp4.model.post.view.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    private val postsViewModel: PostsViewModel by viewModels()

    private lateinit var textView: TextView
    private lateinit var btnFetchData: Button
    private lateinit var btnViewData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        btnFetchData = findViewById(R.id.btnFetchData)
        btnViewData = findViewById(R.id.btnViewData)

        btnFetchData.setOnClickListener {
            fetchPosts()
        }

        btnViewData.setOnClickListener {
            observePosts()
        }
    }

    private fun fetchPosts() {
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()?.let { posts ->
                    postsViewModel.deleteAllPosts()
                    postsViewModel.insertPosts(posts)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                textView.text = "Error: ${t.message}"
            }
        })
    }

    private fun observePosts() {
        postsViewModel.allPosts.observe(this) { posts ->
            val postData = posts.joinToString("\n\n") {
                "ID: ${it.id}\nTitle: ${it.title}\nContent: ${it.body}"
            }
            textView.text = postData
        }
    }
}


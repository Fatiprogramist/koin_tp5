package com.example.tp4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tp4.api.RetrofitClient
import com.example.tp4.database.DatabaseClient
import com.example.tp4.model.post.ApiService
import com.example.tp4.model.post.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

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
            navigateToPostsActivity()
        }
    }

    private fun fetchPosts() {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val call = apiService.getPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    if (posts != null) {
                        savePostsToDatabase(posts)
                        displayPosts(posts)
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                textView.text = "Error: ${t.message}"
            }
        })
    }

    private fun savePostsToDatabase(posts: List<Post>) {
        val postDao = DatabaseClient.getInstance(applicationContext).postDao()

        CoroutineScope(Dispatchers.IO).launch {
            postDao.deleteAllPosts()
            postDao.insertPosts(posts)
        }
    }

    private fun displayPosts(posts: List<Post>) {
        val postData = StringBuilder()
        posts.forEach { post ->
            postData.append("ID: ${post.id}\n")
            postData.append("Title: ${post.title}\n")
            postData.append("Body: ${post.body}\n\n")
        }
        textView.text = postData.toString()
    }

    private fun navigateToPostsActivity() {
        val intent = Intent(this, ViewPostsActivity::class.java)
        startActivity(intent)
    }
}

package com.example.tp4

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.adapter.PostsAdapter
import com.example.tp4.database.DatabaseClient
import com.example.tp4.model.post.Post
import com.example.tp4.repository.PostRepository
import com.example.tp4.viewmodel.PostsViewModel
import com.example.tp4.viewmodel.PostsViewModelFactory

class ViewPostsActivity : AppCompatActivity() {

    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postsAdapter: PostsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_posts)

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postsAdapter = PostsAdapter(emptyList())
        recyclerView.adapter = postsAdapter

        // Initialize the repository and ViewModel
        val postDao = DatabaseClient.getInstance(applicationContext).postDao()
        val repository = PostRepository(postDao)
        val factory = PostsViewModelFactory(repository)

        // Using the ViewModelProvider with the factory
        postsViewModel = ViewModelProvider(this, factory).get(PostsViewModel::class.java)

        // Observe the posts LiveData
        postsViewModel.allPosts.observe(this, Observer { posts ->
            // Update the adapter with the list of posts
            postsAdapter.setPosts(posts)
        })
    }
}

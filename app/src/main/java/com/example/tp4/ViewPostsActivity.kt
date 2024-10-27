package com.example.tp4

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.adapter.PostsAdapter
import com.example.tp4.model.post.view.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPostsActivity : AppCompatActivity() {

    private val postsViewModel: PostsViewModel by viewModels()
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

        // Observe the posts LiveData
        postsViewModel.allPosts.observe(this) { posts ->
            posts?.let {
                postsAdapter.setPosts(it) // Update the adapter with new data
            }
        }
    }
}

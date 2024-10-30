package com.example.tp4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.adapter.PostsAdapter
import com.example.tp4.model.post.view.PostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewPostsActivity : AppCompatActivity() {

    private val postsViewModel: PostsViewModel by viewModel()
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
        postsViewModel.allPosts.observe(this, Observer { posts ->
            // Update the adapter with the list of posts
            postsAdapter.setPosts(posts)
        })
    }
}

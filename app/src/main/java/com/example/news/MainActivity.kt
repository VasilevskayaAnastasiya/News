package com.example.news

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.adapters.NewsAdapter
import com.example.news.data.NewsItemModel
import com.example.news.databinding.ActivityMainBinding
import com.example.news.utils.Utils
import com.example.news.utils.Utils.Companion.dataSet

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.news.layoutManager = LinearLayoutManager(this)

        val adapter = NewsAdapter(dataSet) {NewsItemModel ->
            Log.d("My Log", "clicked on: ${NewsItemModel}")
            Toast.makeText(this, "${NewsItemModel.title}", Toast.LENGTH_SHORT).show()
        }
        binding.news.adapter = adapter
    }

}
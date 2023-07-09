package com.example.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.NewsItemModel
import com.example.news.databinding.ActivityMainBinding
import com.example.news.databinding.ListItemBinding

class NewsAdapter(val list: List<NewsItemModel>,
                  val itemClickListener: (NewsItemModel) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    class NewsItemViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bintItem(item: NewsItemModel){
            with(binding) {
                TitleTextNews.text = item.title
                ContentTextNews.text = item.content
                ImageNews.setImageResource(item.image)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bintItem(currentItem)
        holder.binding.root.setOnClickListener {
            itemClickListener(currentItem)
        }
    }

}
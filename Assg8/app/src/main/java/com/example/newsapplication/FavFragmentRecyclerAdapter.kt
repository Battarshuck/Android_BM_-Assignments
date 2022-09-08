package com.example.newsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FavFragmentRecyclerAdapter: RecyclerView.Adapter<FavFragmentRecyclerAdapter.ArticleHolder>() {

    inner class ArticleHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var ivImage: ImageView
        lateinit var tvTitle: TextView
        lateinit var tvDescription: TextView
        lateinit var tvAuthor: TextView
        var index: Int = 0

        init {
            ivImage = view.findViewById<ImageView>(R.id.iv_fav_article_image)
            tvTitle = view.findViewById<TextView>(R.id.tv_fav_article_title)
            tvDescription = view.findViewById<TextView>(R.id.tv_fav_article_description)
            tvAuthor = view.findViewById<TextView>(R.id.tv_fav_article_author)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavFragmentRecyclerAdapter.ArticleHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fav_article_holder, parent, false)
        return ArticleHolder(view)
    }

    override fun onBindViewHolder(
        holder: FavFragmentRecyclerAdapter.ArticleHolder,
        position: Int
    ) {
        holder.tvTitle.text = favNews[position].title.toString()
        holder.tvDescription.text = favNews[position].description.toString()
        holder.tvAuthor.text = favNews[position].author.toString()
        holder.index = position

        Glide
            .with(holder.itemView)
            .load(apiNews[position].urlToImage)
            .into(holder.ivImage)
    }

    override fun getItemCount() = favNews.size
}
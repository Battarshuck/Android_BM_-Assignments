package com.example.newsapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsFragmentRecyclerAdapter(val favListener: FavListenerInterface): RecyclerView.Adapter<NewsFragmentRecyclerAdapter.ArticleHolder>() {

    inner class ArticleHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var ivImage: ImageView
        lateinit var tvTitle: TextView
        lateinit var tvDescription: TextView
        lateinit var tvAuthor: TextView
        lateinit var btnFavourite: Button

        var index: Int = 0

        init {
            ivImage = view.findViewById<ImageView>(R.id.iv_article_image)
            tvTitle = view.findViewById<TextView>(R.id.tv_article_title)
            tvDescription = view.findViewById<TextView>(R.id.tv_article_description)
            tvAuthor = view.findViewById<TextView>(R.id.tv_article_author)
            btnFavourite = view.findViewById<Button>(R.id.btn_favourite)

            btnFavourite.setOnClickListener{
                    favListener.favListener(index)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.article_holder, parent, false)
        return ArticleHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.tvTitle.text = apiNews[position].title.toString()
        holder.tvDescription.text = apiNews[position].description.toString()
        holder.tvAuthor.text = apiNews[position].author.toString()
        holder.index = position

        Glide
            .with(holder.itemView)
            .load(apiNews[position].urlToImage)
            .into(holder.ivImage)
    }

    override fun getItemCount() = apiNews.size
}
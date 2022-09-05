package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight")
    private val details = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    private val images = arrayOf( R.drawable.drawable_icon_thunderbolt,
        R.drawable.drawable_icon_thunderbolt,  R.drawable.drawable_icon_thunderbolt,
        R.drawable.drawable_icon_thunderbolt,  R.drawable.drawable_icon_thunderbolt,  R.drawable.drawable_icon_thunderbolt,  R.drawable.drawable_icon_thunderbolt,
        R.drawable.drawable_icon_thunderbolt)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.card_image)
            itemTitle = itemView.findViewById(R.id.card_title)
            itemDetail = itemView.findViewById(R.id.card_details)
        }
    }
}
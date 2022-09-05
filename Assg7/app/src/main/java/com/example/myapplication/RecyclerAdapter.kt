package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val userClickObject: UserInfo) :
    RecyclerView.Adapter<RecyclerAdapter.UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.UserHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_view_holder, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.UserHolder, position: Int) {
        holder.tvName.text = ListUsers.get(position).name
        holder.tvJob.text = ListUsers.get(position).job
        holder.index = position

        //NOTE: for memory efficiency you could only store the position variable
        //and then use it to get the data from the original array
    }

    override fun getItemCount() = ListUsers.size

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var tvName: TextView
        lateinit var tvJob: TextView
        var index: Int = 0

        init {
            tvName = view.findViewById<TextView>(R.id.tv_name)
            tvJob = view.findViewById<TextView>(R.id.tv_job)

            tvName.setOnClickListener {
                userClickObject.userClick(index)
            }
        }

    }
}
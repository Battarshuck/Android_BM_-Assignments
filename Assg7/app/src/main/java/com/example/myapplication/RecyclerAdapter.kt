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
        holder.tvMobile = ListUsers.get(position).mobile
        holder.tvEmail = ListUsers.get(position).email
        holder.tvAddress  = ListUsers.get(position).address
    }

    override fun getItemCount() = ListUsers.size

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var tvName: TextView
        lateinit var tvJob: TextView
        lateinit var tvMobile: String
        lateinit var tvEmail: String
        lateinit var tvAddress: String

        init {
            tvName = view.findViewById<TextView>(R.id.tv_name)
            tvJob = view.findViewById<TextView>(R.id.tv_job)

            tvName.setOnClickListener {
                userClickObject.userClick(
                    User(
                        tvName.text.toString(),
                        tvJob.text.toString(),
                        tvMobile,
                        tvEmail,
                        tvAddress
                    )
                )
            }
        }

    }
}
package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BlankFragment(val userClickEvent: UserInfo) : Fragment(R.layout.fragment_blank) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onCreate(savedInstanceState)

        val myRv = view.findViewById<RecyclerView>(R.id.rv_users)

        myRv.layoutManager = LinearLayoutManager(context)

        myRv.adapter = RecyclerAdapter(userClickEvent)

    }


}
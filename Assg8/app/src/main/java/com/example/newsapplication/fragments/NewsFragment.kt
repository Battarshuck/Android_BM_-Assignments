package com.example.newsapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.FavListenerInterface
import com.example.newsapplication.NewsFragmentRecyclerAdapter
import com.example.newsapplication.R


class NewsFragment(val favListener: FavListenerInterface) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myRv = view.findViewById<RecyclerView>(R.id.rv_articles)
        myRv.layoutManager = LinearLayoutManager(context)
        myRv.adapter = NewsFragmentRecyclerAdapter(favListener)
    }

}
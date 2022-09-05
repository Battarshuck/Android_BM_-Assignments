package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DetailsFragment(val user: User) : Fragment(R.layout.fragment_details) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<TextView>(R.id.tv_details_name)
        val job = view.findViewById<TextView>(R.id.tv_details_job)
        val mobile = view.findViewById<TextView>(R.id.tv_details_mobile)
        val email = view.findViewById<TextView>(R.id.tv_details_email)
        val address = view.findViewById<TextView>(R.id.tv_details_address)

        name.text = user.name
        job.text = user.job
        mobile.text = user.mobile
        email.text = user.email
        address.text = user.address
    }

}
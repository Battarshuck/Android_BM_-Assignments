package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), UserInfo {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usersFragment = BlankFragment(this@MainActivity)
        supportFragmentManager.beginTransaction()
            .add(R.id.fcv_myfragment, usersFragment)
            .commit()
    }

    override fun userClick(user: User) {

        val userDetails = DetailsFragment(user)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_myfragment, userDetails)
            .addToBackStack(DetailsFragment::class.simpleName)
            .commit()
    }
}
package com.example.myapplication

import android.provider.ContactsContract
import java.net.Inet4Address

data class User(
    val name: String, val job: String, val mobile: String,
    val email: String, val address: String
) {}
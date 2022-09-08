package com.example.newsapplication

import retrofit2.http.GET
import retrofit2.Call

const val API_KEY: String = "2d8e64bb15dd49a1a73a38b14136e045"

interface NewsService {
    @GET("v2/top-headlines?country=us&apiKey=$API_KEY")
    fun getArticles(): Call<JsonObject>
}
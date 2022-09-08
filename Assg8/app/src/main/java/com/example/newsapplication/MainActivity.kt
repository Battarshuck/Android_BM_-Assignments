package com.example.newsapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.example.newsapplication.fragments.FavFragment
import com.example.newsapplication.fragments.NewsFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log
import kotlinx.coroutines.launch

const val BASE_URL = "https://newsapi.org/"

class MainActivity : AppCompatActivity(), FavListenerInterface {
    var database: DataBasic? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getArticles()

        database = Room.databaseBuilder(this, DataBasic::class.java, "basic.db")
            .allowMainThreadQueries()
            .build()

        val btnRefresh = findViewById<Button>(R.id.btn_main_refresh)
        val btnFavourite = findViewById<Button>(R.id.btn_go_to_fav)

        btnRefresh.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_main_activity, NewsFragment(this@MainActivity))
                .commit()
        }

        btnFavourite.setOnClickListener{
            Toast.makeText(this, "Loading Favourites", Toast.LENGTH_SHORT).show()
            favNews = database?.getUserDao()?.getFavouriteArticles()!!

            supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_main_activity, FavFragment())
                .addToBackStack(FavFragment::class.java.simpleName)
                .commit()
        }

    }


    private fun getArticles() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(NewsService::class.java)

        val retrofitData = retrofitBuilder.getArticles().enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                val responseBody = response.body()!!

                for (article in responseBody.articles)
                {
                    apiNews += article
                }

            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun favListener(index: Int) {
        Toast.makeText(this, "Article Added to Favourites", Toast.LENGTH_SHORT).show()
        val newFavArticle: ArticleEntity = ArticleEntity(
            apiNews[index].author,
            apiNews[index].title,
            apiNews[index].description,
            apiNews[index].url,
            apiNews[index].urlToImage,
            apiNews[index].publishedAt,
            apiNews[index].content
        )

        GlobalScope.launch (Dispatchers.Main) {
            database?.getUserDao()?.insertArticle(newFavArticle)
        }

    }

}
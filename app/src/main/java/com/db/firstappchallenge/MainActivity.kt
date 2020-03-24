package com.db.firstappchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter : NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView() // Adapter instanciado

        Log.e("News APII", getNewsAPIUrl())

        NewsVolley(getNewsAPIUrl(), this, newsAdapter).callNewsAPI()
    }

    private fun setRecyclerView(){
        recycler_view_news.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            newsAdapter = NewsRecyclerAdapter()
            adapter = newsAdapter
        }
    }

    fun getNewsAPIUrl(): String{
        return "https://newsapi.org/v2/everything?q=climate change&apiKey=953df1e82d0e4e23bc5bdc6ccff5041f&pageSize=20"
    }
}

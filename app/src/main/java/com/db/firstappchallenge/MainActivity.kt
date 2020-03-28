package com.db.firstappchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter : NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView() // Adapter instanciado

        Log.i("News APII", getNewsAPIUrl())

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
        return "https://newsapi.org/v2/everything?q=climate-change&apiKey=953df1e82d0e4e23bc5bdc6ccff5041f&pageSize=25&domains=cnn.com,bbc.co.uk&sortBy=popularity"
    }
}

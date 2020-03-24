package com.db.firstappchallenge

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.new_page_layout.*

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_page_layout)

        val news = intent.getSerializableExtra("news") as? News
        textViewDateNews.text = news!!.date.plus("   ").plus(news!!.author)
        textViewTittleNews.text = news!!.title
        textViewContent.text = news!!.content
        imageViewNews.setPic(news!!.image)
    }

    fun ImageView.setPic(url:String){
        val options = RequestOptions()
            .error(R.mipmap.ic_launcher_round)
        Glide.with(this)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(this)
    }
}
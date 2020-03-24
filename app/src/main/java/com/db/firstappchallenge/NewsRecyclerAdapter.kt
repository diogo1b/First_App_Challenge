package com.db.firstappchallenge

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.news_card_layout.view.*

class NewsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private  var news: List<News> = ArrayList()

    /*
    Crea el layout
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_card_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NewsViewHolder -> {
                holder.bind(news.get(position))
                holder.itemView.setOnClickListener {
                    val contexto = it.context
                    val intent = Intent(contexto, NewsActivity::class.java)
                    intent.putExtra("news", news[position])
                    contexto.startActivity(intent)
                    Toast.makeText(contexto, "INSIDE DUDE!!!", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    fun setData(listNews: List<News>){
        news = listNews
        notifyDataSetChanged()
    }

    class NewsViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.textViewCardTitle
        val description = itemView.textViewCardDescription
        val date = itemView.textViewCardDate
        val image = itemView.imageViewCardImage

        fun bind(news: News) {
            title.text = news.title
            date.text = news.date
            description.text = news.description
            image.setPic(news.image)
        }

        fun ImageView.setPic(url: String) {
            val options = RequestOptions()
                .error(R.mipmap.ic_launcher_round)
            Glide.with(this)
                .setDefaultRequestOptions(options)
                .load(url)
                .into(this)
        }
    }
}
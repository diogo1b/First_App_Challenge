package com.db.firstappchallenge

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class NewsVolley(val url:String, val contexto: Context, val newsAdapter: NewsRecyclerAdapter){
    val queue = Volley.newRequestQueue(contexto)

    fun callNewsAPI(){

        val dataNews = ArrayList<News>()
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val not = response.getJSONArray("articles")
                for (i in 0..not.length()-1){
                    val obj = not.getJSONObject(i)

                    val title = obj.getString("title")
                    val author = obj.getString("author")
                    val description = obj.getString("description")
                    val content = obj.getString("content")
                    val date = obj.getString("publishedAt")
                    val image = obj.getString("urlToImage")

                    val news  =  News(title, author, description, content, date, image)
                    if(content != "null" || author != "null" || description != "null" || date != "null" || image != "null") {
                        dataNews.add(news)
                    }
                }
                newsAdapter.setData(dataNews)

            },
            Response.ErrorListener {
                Log.i("Volley Error", it.toString())
                Toast.makeText(contexto, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}
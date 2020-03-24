package com.db.firstappchallenge

import java.io.Serializable

data class News (val title :String, val author:String, val description :String, val content :String, val date :String, val image :String) : Serializable
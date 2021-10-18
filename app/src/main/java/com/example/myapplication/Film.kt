package com.example.myapplication

import android.net.Uri
import android.widget.ImageView
import java.io.Serializable

data class Film(var uri_string:String,
                var title :String,
                var rate :String,
                var discription:String):Serializable

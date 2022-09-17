package com.example.youtubeapi.extention

import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url:String){
    Glide.with(this).load(url).into(this)
}
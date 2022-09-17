package com.example.youtubeapi.utils

import android.app.Application
import com.example.youtubeapi.repository.Repository

class App: Application() {

    companion object{
        val repository : Repository by lazy { Repository() }
    }
}
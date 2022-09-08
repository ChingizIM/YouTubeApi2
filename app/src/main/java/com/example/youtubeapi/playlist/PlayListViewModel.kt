package com.example.youtubeapi.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.`object`.Constant
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.model.Playlists
import com.example.youtubeapi.remote.ApiService
import com.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PlayListViewModel : BaseViewModel() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlists(): LiveData<Playlists> {
        return getPlaylists()
    }

    private fun getPlaylists(): LiveData<Playlists> {
        val data = MutableLiveData<Playlists>()
        apiService.getPlaylists(Constant.channelId, Constant.part, BuildConfig.API_KEY).enqueue(object :retrofit2.Callback<Playlists> {
            override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                if (response.isSuccessful)
                    data.value = response.body()
            }

            override fun onFailure(call: Call<Playlists>, t: Throwable) {
            }

        })

        return data;

    }


}

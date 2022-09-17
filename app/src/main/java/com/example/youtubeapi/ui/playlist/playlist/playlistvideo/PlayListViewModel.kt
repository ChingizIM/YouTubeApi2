package com.example.youtubeapi.ui.playlist.playlist.playlistvideo

import androidx.lifecycle.LiveData
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.remote.model.Item
import com.example.youtubeapi.utils.App.Companion.repository

class PlayListVideoViewModel : BaseViewModel() {

    fun getPlaylistItems(playlistId: String): LiveData<Resource<Item>> {
        return repository.getPlaylistItems(playlistId)
    }

}
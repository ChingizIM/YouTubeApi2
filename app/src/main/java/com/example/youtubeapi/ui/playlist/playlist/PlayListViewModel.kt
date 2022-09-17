package com.example.youtubeapi.ui.playlist.playlist

import androidx.lifecycle.LiveData
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.remote.model.Playlists
import com.example.youtubeapi.utils.App.Companion.repository

class PlayListViewModel : BaseViewModel() {
    fun getPlaylists(): LiveData<Resource<Playlists>> {
        return repository.getPlaylists()

    }
}

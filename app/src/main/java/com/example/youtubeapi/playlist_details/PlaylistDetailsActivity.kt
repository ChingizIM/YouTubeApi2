package com.example.youtubeapi.playlist_details

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityPlaylistDetailsBinding
import com.example.youtubeapi.playlist.PlayListActivity
import com.example.youtubeapi.playlist.PlayListActivity.Companion.KEY


class PlaylistDetailsActivity() :
    BaseActivity<PlaylistDetailsViewModel, ActivityPlaylistDetailsBinding>() {
    override val viewModel: PlaylistDetailsViewModel by lazy {
        ViewModelProvider(this)[PlaylistDetailsViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistDetailsBinding {
        return ActivityPlaylistDetailsBinding.inflate(inflater)
    }

    override fun initView() {
        val channelId = intent.getStringExtra(PlayListActivity.KEY)
        Toast.makeText(this, channelId, Toast.LENGTH_SHORT).show()
    }
}
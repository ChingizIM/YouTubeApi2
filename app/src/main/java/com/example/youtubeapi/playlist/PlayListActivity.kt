package com.example.youtubeapi.playlist

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityPlaylistBinding
import com.example.youtubeapi.model.Item
import com.example.youtubeapi.playlist_details.PlaylistDetailsActivity

class PlayListActivity: BaseActivity<PlayListViewModel, ActivityPlaylistBinding>() {

    companion object{
        const val  KEY ="key"
    }
    override val viewModel:PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.playlists().observe(this){
            Toast.makeText(this, it.kind.toString(), Toast.LENGTH_SHORT).show()
            initRecyclerView(it.items)
        }
    }
    private fun initRecyclerView(playlistsList: List<Item>){
        binding.recyclerMain.adapter = PlaylistAdapter(playlistsList, this::onItemClick)
    }
    private fun onItemClick(channelId: String){
        val intent = Intent(this, PlaylistDetailsActivity::class.java)
        intent.putExtra(KEY,channelId)
        startActivity(intent)
    }
}
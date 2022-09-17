package com.example.youtubeapi.ui.playlist.playlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.core.network.result.Status
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.data.remote.model.Item
import com.example.youtubeapi.databinding.ActivityMainBinding
import com.example.youtubeapi.preference.Prefs
import com.example.youtubeapi.ui.playlist.playlist.playlistvideo.PlayListVideoActivity
import com.example.youtubeapi.utils.CheckConnectNetwork
import com.example.youtubeapi.utils.NetworkStatus
import com.example.youtubeapi.utils.NetworkStatusHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListActivity : BaseActivity<PlayListViewModel, ActivityMainBinding>() {

    override val viewModel: PlayListViewModel
        get() = ViewModelProvider(this)[PlayListViewModel::class.java]

    private val prefs: Prefs by lazy { Prefs(this) }
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    private fun initRecyclerView(playlistsList: List<Item>) {
        binding.recyclerView.adapter =
            PlaylistsAdapter(playlistsList as ArrayList<Item>, this::onItemClick)
    }

    private fun onItemClick(channelId: String, playlistTitle: String, playlistDescription: String) {
        Intent(this, PlayListVideoActivity::class.java).apply {
            putExtra(FIRST_KEY, channelId)
            putExtra(SECOND_KEY, playlistTitle)
            putExtra(THIRD_KEY, playlistDescription)
            startActivity(this)
        }
    }

    companion object {
        const val FIRST_KEY = "one_key"
        const val SECOND_KEY = "two_key"
        const val THIRD_KEY = "third_key"
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylists().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { it1 ->
                        initRecyclerView(it1.items)
                        binding.progressbar.isVisible = false
                    }
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    binding.progressbar.isVisible = false
                }
                Status.LOADING -> {
                    binding.progressbar.isVisible = true
                }
            }
        }
    }

    override fun initView() {
        super.initView()
        prefs.onBoard = !prefs.onBoard
    }


    override fun checkInternet() {
        super.checkInternet()
        CheckConnectNetwork(this).observe(this) { isConnected ->
            binding.includeNoInet.rlParent.isVisible = !isConnected
            binding.recyclerView.isVisible = isConnected
        }
    }
}
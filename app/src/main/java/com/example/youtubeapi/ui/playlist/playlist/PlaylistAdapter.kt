package com.example.youtubeapi.ui.playlist.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.data.remote.model.Item
import com.example.youtubeapi.databinding.PlaylistItemBinding
import com.example.youtubeapi.extention.loadImage

class PlaylistsAdapter(
    private var data: ArrayList<Item>,
    private val onItemClick: (item: String, String, String) -> Unit?
) : RecyclerView.Adapter<PlaylistsAdapter.PlayListsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        val binding =
            PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return PlayListsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PlayListsViewHolder(var binding: PlaylistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivVideos.loadImage(item.snippet.thumbnails.default.url)
            binding.tvName.text=item.snippet.title
            binding.tvDesc.text=String.format("${item.contentDetails.itemCount}${"video series"}")
            binding.root.setOnClickListener{
                onItemClick(item.id,item.snippet.title,item.snippet.description)
            }
        }
    }
}



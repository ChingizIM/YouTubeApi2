package com.example.youtubeapi.playlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi.databinding.ItemListBinding
import com.example.youtubeapi.model.Item

class PlaylistAdapter(
    private val list: List<Item>,
    private val onItemClick : (itemsId: String) -> Unit?
) : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    var binding: ItemListBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistAdapter.ViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding?: ItemListBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(items: Item) {
            Glide.with(binding.root)
                .load(items.snippet.thumbnails.default.url)
                .into(binding.screenshot)
            binding.playlistNameTv.text = items.snippet.title
            binding.playlistCountTv.text =
                items.contentDetails.itemCount.toString() + "video series"
            itemView.setOnClickListener {
                onItemClick(items.id)
            }
        }
    }
}
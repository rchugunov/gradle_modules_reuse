package com.rchugunov.feature_list

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rchugunov.domain.PhotoItem
import com.rchugunov.feature_list.databinding.ViewItemPhotoBinding
import java.io.InputStream


internal class PhotosAdapter(private val photoClicksHandler: (PhotoItem) -> Unit) :
    ListAdapter<PhotoItem, PhotosAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewItemPhotoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoItem = getItem(position)
        holder.bind(photoItem)
        holder.itemView.setOnClickListener {
            photoClicksHandler(photoItem)
        }
    }

    class ViewHolder(private val binding: ViewItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photoItem: PhotoItem) {
            val ims: InputStream = itemView.context.assets.open(THUMBS_DIRECTORY + photoItem.name)
            val d = Drawable.createFromStream(ims, null)
            binding.viewPhoto.setImageDrawable(d)
            ims.close()
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PhotoItem>() {
            override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
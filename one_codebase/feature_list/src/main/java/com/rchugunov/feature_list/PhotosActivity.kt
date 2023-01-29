package com.rchugunov.feature_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.rchugunov.deature_details.DetailsActivity
import com.rchugunov.domain.PhotoItem
import com.rchugunov.feature_list.databinding.ActivityPhotosBinding

class PhotosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotosBinding

    private val photosAdapter = PhotosAdapter { photoItem ->
        startActivity(DetailsActivity.newIntent(this, photoItem.name))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPhotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = photosAdapter
            layoutManager = GridLayoutManager(this@PhotosActivity, 3)
        }

        loadItems()
    }

    private fun loadItems() {
        val fileNames = requireNotNull(assets.list(THUMBS_DIRECTORY))

        photosAdapter.submitList(fileNames.map {
            PhotoItem(
                name = it,
                isThumbnail = true
            )
        })
    }
}

internal const val THUMBS_DIRECTORY = "thumbs/"
package com.rchugunov.deature_details

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.rchugunov.deature_details.databinding.ActivityDetailsBinding
import com.rchugunov.domain.PhotoItem
import java.io.FileNotFoundException
import java.io.InputStream

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private val photoItem by lazy(LazyThreadSafetyMode.NONE) {
        PhotoItem(
            name = requireNotNull(intent.getStringExtra(EXTRA_PHOTO_NAME)),
            isThumbnail = false
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadContent()
    }

    private fun loadContent() {
        try {
            val ims: InputStream = assets.open(FULL_SIZE_PHOTOS_DIR + photoItem.name)
            val d = Drawable.createFromStream(ims, null)
            binding.viewPhoto.setImageDrawable(d)
            ims.close()
        } catch (ex: FileNotFoundException) {
            Snackbar.make(
                window.decorView,
                getString(R.string.photo_not_found),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        private const val EXTRA_PHOTO_NAME = "EXTRA_PHOTO_NAME"

        fun newIntent(context: Context, photoName: String): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_PHOTO_NAME, photoName)
            }
        }
    }
}

internal const val FULL_SIZE_PHOTOS_DIR = "full_size/"
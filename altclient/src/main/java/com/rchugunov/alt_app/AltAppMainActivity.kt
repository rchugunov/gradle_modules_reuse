package com.rchugunov.alt_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rchugunov.alt_app.databinding.ActivityAltAppMainBinding
import com.rchugunov.feature_list.PhotosActivity

class AltAppMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAltAppMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAltAppMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, PhotosActivity::class.java))
        }
    }
}
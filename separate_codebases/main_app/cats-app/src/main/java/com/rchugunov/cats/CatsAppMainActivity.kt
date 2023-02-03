package com.rchugunov.cats

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rchugunov.cats.databinding.ActivityCatsMainBinding
import com.rchugunov.feature_list.PhotosActivity

class CatsAppMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCatsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, PhotosActivity::class.java))
        }
    }
}
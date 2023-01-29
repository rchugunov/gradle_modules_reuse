package com.rchugunov.dogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rchugunov.deature_details.DetailsActivity
import com.rchugunov.dogs.databinding.ActivityAppDogsBinding

class DogsAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppDogsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppDogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(
                DetailsActivity.newIntent(
                    this,
                    "GettyImages-997141470-e1614176377827.jpg"
                )
            )
        }

        binding.button2.setOnClickListener {
            startActivity(DetailsActivity.newIntent(this, "large-dog-breeds-lead-1550810820.jpg"))
        }

        binding.button3.setOnClickListener {
            startActivity(DetailsActivity.newIntent(this, "pug-with-eggs.jpeg"))
        }
    }
}
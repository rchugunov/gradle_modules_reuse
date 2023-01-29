package com.rchugunov.multi_module

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rchugunov.deature_details.DetailsActivity
import com.rchugunov.multi_module.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(DetailsActivity.newIntent(this, "-6027996.jpg"))
        }

        binding.button2.setOnClickListener {
            startActivity(DetailsActivity.newIntent(this, "-12804209.jpg"))
        }

        binding.button3.setOnClickListener {
            startActivity(DetailsActivity.newIntent(this, "-17829784.jpg"))
        }
    }
}
package com.tomuchcoffee.submissionbmaap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tomuchcoffee.submissionbmaap.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
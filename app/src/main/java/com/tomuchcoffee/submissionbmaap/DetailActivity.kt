package com.tomuchcoffee.submissionbmaap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tomuchcoffee.submissionbmaap.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityDetailBinding

    companion object {
        const val CHAR_NAME = "char_name"
        const val CHAR_DETAIL = "char_detail"
        const val CHAR_SWORDSMANSHIP = "char_swordsmanship"
        const val CHAR_PHOTO = "char_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionBarTittle = supportActionBar
        actionBarTittle?.title = "Detail Activity"
        actionBarTittle?.setDisplayHomeAsUpEnabled(true)

        setUpView()
    }

    private fun setUpView() {
        with(binding){
            tvCharacternamedetail.setText(intent.getStringExtra(CHAR_NAME))
            tvCharacterinfodetail.setText(intent.getStringExtra(CHAR_DETAIL))
            tvCharacterswordmanship.setText(intent.getStringExtra(CHAR_SWORDSMANSHIP))
           Glide.with(this@DetailActivity)
               .load(intent.getStringExtra(CHAR_PHOTO)?.toInt())
               .apply(RequestOptions())
               .into(ivCharacktersdetail)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
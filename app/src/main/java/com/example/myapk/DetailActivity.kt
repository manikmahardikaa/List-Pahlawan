package com.example.myapk

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailActivity : AppCompatActivity() {

    companion object {
        const val key_movie = "key_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMovie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(key_movie, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(key_movie)
        }

        if (dataMovie != null) {
            val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
            val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
            val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

            tvDetailName.text = dataMovie.name
            tvDetailDescription.text = dataMovie.description
            ivDetailPhoto.setImageResource(dataMovie.photo)
        }
    }
}

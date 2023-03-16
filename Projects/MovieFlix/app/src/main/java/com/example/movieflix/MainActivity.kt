package com.example.movieflix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val BtnNowPlaying= findViewById<Button>(R.id.nowPlayingBtn)
        val BtnTrending = findViewById<Button>(R.id.trendingBtn)
        val BtnTopRated = findViewById<Button>(R.id.topRatedBtn)


        BtnNowPlaying.setOnClickListener{
            val intent = Intent(this@MainActivity, NowPlaying::class.java)
            startActivity(intent)
            //intent.putExtra(supportFragmentManager)

        }
    }
}
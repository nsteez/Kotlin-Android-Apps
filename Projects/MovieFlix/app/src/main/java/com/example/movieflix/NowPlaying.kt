package com.example.movieflix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NowPlaying : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
            setContentView(R.layout.now_playing)
            val supportFragmentManager = supportFragmentManager
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content, MovieFragment(),null).commit()


    }



}
package com.example.movieflix

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


class ActorsDetails : AppCompatActivity(){
    private lateinit var detailImage: ImageView
    private lateinit var overview: TextView
    private lateinit var popularity: TextView
    private lateinit var title_: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actor_details)

        Log.d("NewPage ","NewPage")

        val actorNotes = intent.getSerializableExtra(ACTOR_EXTRA) as Actor
        val knownFor = actorNotes.known

        Log.d("knownFor", knownFor.toString())

        detailImage = findViewById(R.id.detailImageTv)
        overview = findViewById(R.id.knownForOverviewTv)
        popularity = findViewById(R.id.popularityTv)
        title_ = findViewById(R.id.titleTv)



        popularity.text = "Popularity: " + actorNotes.popularity
        title_.text = "Most Known For: " + knownFor[0].title;
        overview.text = knownFor[0].overview

        val baseUrl = "https://image.tmdb.org/t/p/w400"
        val radius = 120
        Glide.with(this)
            .load(baseUrl+ actorNotes.imageUrl)
            .transform(RoundedCorners(radius))
            .into(detailImage)


        //title_.text = actorNotes.known?.title

    }
}
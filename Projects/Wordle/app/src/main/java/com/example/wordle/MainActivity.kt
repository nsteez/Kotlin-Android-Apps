package com.example.wordle

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gamePlayIntent = Intent(this, GamePlay::class.java)

        val thingsBtn = findViewById<Button>(R.id.thingBtn);
        val placesBtn = findViewById<Button>(R.id.placeBtn);
        val animalsBtn = findViewById<Button>(R.id.animalBtn);
        val randomBtn = findViewById<Button>(R.id.randomBtn);


        thingsBtn.setOnClickListener{
            val wordToGuessVal = Word.FourLetterThings.getRandomFourLetterWord();
            gamePlayIntent.putExtra("Type",wordToGuessVal)
            Log.d("type",wordToGuessVal)
            startActivity(gamePlayIntent)
        }

        placesBtn.setOnClickListener{
            val wordToGuessVal = Word.FourLetterPlace.getRandomFourLetterWord();
            intent.putExtra("Type",wordToGuessVal)
            startActivity(gamePlayIntent)
        }

        animalsBtn.setOnClickListener{
            val wordToGuessVal = Word.FourLetterAnimals.getRandomFourLetterWord();
            intent.putExtra("Type",wordToGuessVal)
            startActivity(gamePlayIntent)
        }

        randomBtn.setOnClickListener{
            val wordToGuessVal = Word.FourLetterRandom.getRandomFourLetterWord();
            intent.putExtra("Type",wordToGuessVal)
            startActivity(gamePlayIntent)
        }
    }

}
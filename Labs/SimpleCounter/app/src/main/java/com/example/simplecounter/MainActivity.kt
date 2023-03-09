package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<ImageButton>(R.id.btnAdd)
        val btnUpgrade = findViewById<Button>(R.id.btnUpgrade)
        val textView = findViewById<TextView>(R.id.textAdd)
        var counter = 0

        btnAdd.setOnClickListener{
            counter++
            textView.text = counter.toString()

            if (counter >= 10) {
                btnUpgrade.visibility = View.VISIBLE
                btnUpgrade.setOnClickListener{
                    //btnAdd.text = "Add 2"

                    btnAdd.setOnClickListener{
                        counter+=2
                        textView.text = counter.toString()
                    }
                    btnUpgrade.visibility = View.INVISIBLE


                }
            }
        }

    }
}
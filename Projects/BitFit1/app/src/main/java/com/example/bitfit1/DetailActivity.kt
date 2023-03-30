package com.example.bitfit1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DetailActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener{

            val food = findViewById<EditText>(R.id.inputFood).text.toString()
            val calories = findViewById<EditText>(R.id.inputCalories).text.toString()
            val dateTimeText = findViewById<TextView>(R.id.dateDisplay)

            //val pattern = "MM-dd-yyyy"
            val date = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm")
            val formatted = date.format(formatter).toString()


            Log.d("date", formatted)
            dateTimeText.text = formatted

            //co-routine that inserts an individual item
            lifecycleScope.launch(Dispatchers.IO) {
                (application as MyApplication).db.nutritionDao().insert(
                    Nutrition(food, calories, formatted)
                )
            }
            val i = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(i)
        }
    }
}
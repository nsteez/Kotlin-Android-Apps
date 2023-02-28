package com.example.wordle

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

        var numberOfGuess = 3;
        val guess = findViewById<EditText>(R.id.txtGuess);
        val guessBtn = findViewById<Button>(R.id.btnGuess);

        val guess1 = findViewById<TextView>(R.id.guess1);
        val guess2 = findViewById<TextView>(R.id.guess2);
        val guess3 = findViewById<TextView>(R.id.guess3);

        val guessCheck1 = findViewById<TextView>(R.id.guessCheck1);
        val guessCheck2 = findViewById<TextView>(R.id.guessCheck2);
        val guessCheck3 = findViewById<TextView>(R.id.guessCheck3);

        val word = findViewById<TextView>(R.id.word);
//        val wordToGuessVal = Word.FourLetterWordList.getRandomFourLetterWord();
        val wordToGuessVal = "help"

        val winToast = Toast.makeText(this, "Congratulations!! You won", Toast.LENGTH_LONG);
        val loseToast = Toast.makeText(this, "Game Over", Toast.LENGTH_LONG);


        /**
        * Returns a String of 'O', '+', and 'X', where:
        *   'O' represents the right letter in the right place
        *   '+' represents the right letter in the wrong place
        *   'X' represents a letter not in the target word
        */
        fun checkGuess(guess: String): String {
            var result = ""
            //val color = ForegroundColorSpan(Color.rgb(158, 158, 158));
            //val sb = SpannableString(guess)

            for (i in 0..3) {
                if (guess[i] == wordToGuessVal[i]) {
                    result += "O"
                } else if (guess[i] in wordToGuessVal) {
                    result += "+"
                } else {
                    result += "X"
                }
            }
            return result
        }

        fun resetGame() {
            guess1.visibility = View.INVISIBLE
            guessCheck1.visibility = View.INVISIBLE
            guess2.visibility = View.INVISIBLE
            guessCheck2.visibility = View.INVISIBLE
            guess3.visibility = View.INVISIBLE
            guessCheck3.visibility = View.INVISIBLE
            numberOfGuess = 3
            word.text = "Word To Guess"
        }

        fun gamePlay(guess: String) {
            if (guess == wordToGuessVal) {
                word.visibility = View.VISIBLE;

                val timer = object: CountDownTimer(3000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        word.text = "help";
                    }
                    override fun onFinish() {
                        Log.d("setting wordToGuess text", guess);
                        resetGame()
                        winToast.show()
                    }
                }
                timer.start()
                return
            }
                if (numberOfGuess == 3) {
                    numberOfGuess -= 1
                    guess1.text = guess;
                    guess1.visibility = View.VISIBLE
                    guessCheck1.visibility = View.VISIBLE
                    guessCheck1.text = checkGuess(guess)
                } else if (numberOfGuess == 2) {
                    numberOfGuess -= 1
                    guess2.text = guess;
                    guess2.visibility = View.VISIBLE
                    guessCheck2.visibility = View.VISIBLE
                    guessCheck2.text = checkGuess(guess)
                } else if (numberOfGuess == 1) {
                    numberOfGuess -= 1
                    guess3.text = guess;
                    guess3.visibility = View.VISIBLE
                    guessCheck3.visibility = View.VISIBLE
                    guessCheck3.text = checkGuess(guess)
                } else {
                    loseToast.show()
                    resetGame()
                    return
                }
            }

            guessBtn.setOnClickListener {
                val guess = guess.text.toString();
                gamePlay(guess);
            }
        }
    }
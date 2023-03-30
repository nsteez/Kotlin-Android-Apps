package com.example.bitfit1

import android.app.Application

/**
 * Creating an instance of the Database
 */
class MyApplication: Application() {
    val db by lazy {
        AppDatabase.getInstance(this) }
}
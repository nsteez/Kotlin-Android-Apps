package com.example.tmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: MutableList<Email>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRV);
        // Get the list of emails
        emails = EmailFetcher.getEmails();
        // Create adapter passing in the list of emails
        val adapter = EmailAdapter(emails);

        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter;

        // Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this);


        findViewById<Button>(R.id.btn_load_more).setOnClickListener{
            // Fetch net 5 emails and display in RecyclerView
            val nextFive= EmailFetcher.getNext5Emails();
            emails.addAll(nextFive);
            adapter.notifyDataSetChanged();
        }

    }
}
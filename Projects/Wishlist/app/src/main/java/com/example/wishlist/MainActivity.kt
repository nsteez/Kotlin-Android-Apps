package com.example.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<WishItem>;
    lateinit var urlLink: String;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var items: MutableList<WishItem> = ArrayList()
        items = ArrayList()
        urlLink = String.toString();

        val wishlistItemsRV = findViewById<RecyclerView>(R.id.wishlistRv);
        val adapter = WishlistAdapter(items)
        wishlistItemsRV.adapter = adapter
        wishlistItemsRV.layoutManager = LinearLayoutManager(this)

        val nameET = findViewById<EditText>(R.id.name_editText)
        val urlET = findViewById<EditText>(R.id.url_editText)
        val priceET = findViewById<EditText>(R.id.price_editText)
        val submitBtn = findViewById<Button>(R.id.btn_submit)

        submitBtn.setOnClickListener{
            val name = nameET.text.toString()
            val price = priceET.text.toString()
            urlLink = urlET.text.toString()
            Log.d("The link",urlLink)
            var allItems = WishItem(name, price, urlLink)

            if (name.isEmpty() and price.isEmpty() and urlLink.isEmpty()){
                Toast.makeText(it.context,"Empty Values Cannot be added to the list", Toast.LENGTH_SHORT).show()
            } else{
                items.add(allItems)
                Toast.makeText(it.context,"Values added to wishlist", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
                nameET.text.clear()
                urlET.text.clear()
                priceET.text.clear()
            }

        }
        urlET.setOnClickListener{
            Log.d("this lnk","this link")
            try {

                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urlLink))
                ContextCompat.startActivity(it.context, browserIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Invalid URL for " + urlLink.toString(), Toast.LENGTH_LONG).show()
            }


        }

    }
}
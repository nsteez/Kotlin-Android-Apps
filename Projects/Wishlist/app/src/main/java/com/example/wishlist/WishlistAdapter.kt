package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class WishlistAdapter (private val items: List<WishItem>):RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTextView:TextView
        val priceTextView:TextView
        val urlTextView:TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTv)
            priceTextView = itemView.findViewById(R.id.priceTv)
            urlTextView = itemView.findViewById(R.id.urlTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishListView = inflater.inflate(R.layout.wish_item,parent, false)
        return ViewHolder(wishListView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = items.get(position)
        holder.nameTextView.text = wish.name
        holder.priceTextView.text = wish.price
        holder.urlTextView.text = wish.url

    }
}
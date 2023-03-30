package com.example.bitfit1


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val NUTRITION_EXTRA = "NUTRITION_EXTRA"

class NutritionAdapter(private val context: Context, private val items: List<Nutrition>) :
        RecyclerView.Adapter<NutritionAdapter.ViewHolder>() {

    // listener object, custom listener
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false)
        return ViewHolder(view, mListener)
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private val food = itemView.findViewById<TextView>(R.id.foodTv)
        private val calories = itemView.findViewById<TextView>(R.id.caloriesTv)
        private val dateTime = itemView.findViewById<TextView>(R.id.dateTimeTv)

        init { // Each row of the recycler view
            itemView.setOnLongClickListener {
                listener.onItemClick(adapterPosition)
                true
            }
        }

        fun bind(nutrition: Nutrition) {
            food.text = nutrition.food
            calories.text = nutrition.calories
            dateTime.text = nutrition.dateTime
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }


    override fun getItemCount() = items.size


//    override fun onClick(v: View?) {
//        val item = items[absoluteAdapterPosition]
//
//        val intent = Intent(context, DetailActivity::class.java)
//        intent.putExtra(NUTRITION_EXTRA, item)
//        context.startActivity(intent)
//
//    }
}
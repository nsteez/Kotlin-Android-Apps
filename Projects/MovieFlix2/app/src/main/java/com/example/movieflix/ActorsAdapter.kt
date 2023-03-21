package com.example.movieflix

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

const val ACTOR_EXTRA = "ACTOR_EXTRA"

class ActorsAdapter(private val context: Context, private val actors:List<Actor>
):
    RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_actor,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount() = actors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actor = actors[position]
        holder.bind(holder, actor, position)
        //holder.itemView.setOnClickListener{ onItemClicked(actor)}
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var mActor : Int = -1
        private val faceImage = itemView.findViewById<ImageView>(R.id.actImage)
        private val nameText = itemView.findViewById<TextView>(R.id.actNameTv)

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(holder:ViewHolder, actor: Actor, position: Int) {
            mActor = position
            nameText.text = actor.name
            //faceImage = actor.imageUrl
            val baseUrl = "https://image.tmdb.org/t/p/w400"
            //Log.d("image", base_url+actor.imageUrl.toString())


            //val radius = 30
            Glide.with(holder.faceImage)
                .load(baseUrl + actor.imageUrl)
                //.transform(RoundedCorners(radius))
                .into(holder.faceImage)

        }

            override fun onClick(v: View?) {
                var act = actors[mActor]


                val intent = Intent(context, ActorsDetails::class.java)
                //Log.d("onclickActor", "actorsDetails")
                //Log.d("Act", act.toString())


                intent.putExtra(ACTOR_EXTRA, act)
//                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    this,
//                  v, "actor_items_transition"
//                )
                context.startActivity(intent)


            }

 }
}
package com.jcbivfaulm.mvvmexample.movie.view.adapter

import android.content.Context
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.jcbivfaulm.mvvmexample.R
import com.jcbivfaulm.mvvmexample.movie.model.Response
import com.squareup.picasso.Picasso

class RecyclerAdapter(private var mylist: List<Response>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var itemClick: (position: Int) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(inflate)

    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mylist[position])
        holder.itemClick = itemClick


    }

    fun setItems(list: List<Response>){
        mylist = list
        notifyDataSetChanged()

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemClick :(position:Int)->Unit={ }

        var imageIV: ImageView
        var titletx: TextView
        var ratingtx: TextView
        var yeartx: TextView
        var genertx: TextView

        init {
            imageIV = itemView.findViewById(R.id.image_view)
            titletx = itemView.findViewById(R.id.title)
            ratingtx = itemView.findViewById(R.id.rating)
            yeartx = itemView.findViewById(R.id.year)
            genertx= itemView.findViewById(R.id.gener)
            itemView.setOnClickListener {
                itemClick(adapterPosition)
            }
        }
        fun bind( respo:Response){
             Picasso.get()
                 .load(Uri.parse(respo.image))
                 .into(imageIV)
            titletx.text = respo.title
            ratingtx.text = respo.rating.toString()
            yeartx.text=  respo.releaseYear.toString()
            genertx.text= respo.genre.toString()
        }
    }
}
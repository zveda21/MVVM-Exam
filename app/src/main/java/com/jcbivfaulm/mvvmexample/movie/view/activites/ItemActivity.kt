package com.jcbivfaulm.mvvmexample.movie.view.activites

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jcbivfaulm.mvvmexample.R
import com.jcbivfaulm.mvvmexample.movie.model.Response
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    lateinit var item: Response
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        if (intent.hasExtra("item") ){
            item = intent.getParcelableExtra<Response>("item")
            Picasso.get()
                .load(Uri.parse(item.image))
                .into(newImage)
            new_title.text = item.title
            new_rating.text = item.rating.toString()
            new_year.text = item.releaseYear.toString()
            new_genre.text = item.genre.toString()

        }
    }
}

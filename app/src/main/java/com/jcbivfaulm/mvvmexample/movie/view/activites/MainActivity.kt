package com.jcbivfaulm.mvvmexample.movie.view.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcbivfaulm.mvvmexample.R
import com.jcbivfaulm.mvvmexample.movie.model.Response
import com.jcbivfaulm.mvvmexample.movie.view.adapter.RecyclerAdapter
import com.jcbivfaulm.mvvmexample.movie.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list = emptyList<Response>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myViewModel :MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        myViewModel.getRepoData()



        myViewModel.modelmutableLiveData.observe(this, Observer {
            list = it

                Log.d("Helooo","MyView Model = ${it!![0].title}")
                ( recycler.adapter as RecyclerAdapter).setItems(it)


        }



    )
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerAdapter(list).apply {
            itemClick = {
                val intentItem = Intent(this@MainActivity,ItemActivity::class.java)
                intentItem.putExtra("item", list[it])
                startActivity(intentItem)
            }
        }
    }
}

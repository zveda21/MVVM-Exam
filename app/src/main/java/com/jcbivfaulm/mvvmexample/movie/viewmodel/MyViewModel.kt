package com.jcbivfaulm.mvvmexample.movie.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jcbivfaulm.mvvmexample.movie.model.Response
import com.jcbivfaulm.mvvmexample.repo.Repository
import retrofit2.Call
import retrofit2.Callback

class MyViewModel(application: Application) : AndroidViewModel(application) {

    var modelmutableLiveData: MutableLiveData<List<Response>>

    init {
        modelmutableLiveData = MutableLiveData()
    }

    fun getRepoData() {
        Repository.getFilms().enqueue(object : Callback<List<Response>> {
            override fun onFailure(call: Call<List<Response>>, t: Throwable) {
                Toast.makeText(getApplication(), "Failure", Toast.LENGTH_SHORT).show()
                Log.d("Failure", t.message)
            }

            override fun onResponse(
                call: Call<List<Response>>,
                response: retrofit2.Response<List<Response>>
            ) {
                if (response.isSuccessful) {
                    modelmutableLiveData.value = response.body()
                    Log.d("Hello", response.body()?.size.toString())
                }
            }

        })
    }
}
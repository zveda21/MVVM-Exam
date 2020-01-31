package com.jcbivfaulm.mvvmexample.repo


import com.jcbivfaulm.mvvmexample.client.ApiClient
import com.jcbivfaulm.mvvmexample.client.FilmsAPI
import com.jcbivfaulm.mvvmexample.movie.model.Response
import retrofit2.Call

object Repository {
    fun getFilms(): Call<List<Response>> = ApiClient.get().create(FilmsAPI::class.java).getData()

}
package com.jcbivfaulm.mvvmexample.client


import com.jcbivfaulm.mvvmexample.constants.AppConstants
import com.jcbivfaulm.mvvmexample.movie.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface FilmsAPI {
    @GET(AppConstants.END_POINT)
    fun getData(): Call<List<Response>>
}
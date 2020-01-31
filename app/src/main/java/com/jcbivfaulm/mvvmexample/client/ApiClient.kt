package com.jcbivfaulm.mvvmexample.client

import com.jcbivfaulm.mvvmexample.constants.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        fun get():Retrofit{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.BASE_URL)
                .build()

        }
    }
}
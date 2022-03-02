package com.denny.epoxy_sample.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Array.get
import java.util.concurrent.Executors

/**
 * author: Denny
 * created on: 2022/3/2 上午 09:35
 */
class RetrofitManager {
    lateinit var myAPIService: MyAPIService;

    companion object {
        var mInstance: RetrofitManager = RetrofitManager()

    }

    fun getInstance(): RetrofitManager {
        return mInstance
    }

    constructor() {
        var client:OkHttpClient =OkHttpClient.Builder()
            .addInterceptor(ApiInterceptor())
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .callbackExecutor(Executors.newSingleThreadExecutor()) //set call back is background thread
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        myAPIService = retrofit.create(MyAPIService::class.java)
    }
}
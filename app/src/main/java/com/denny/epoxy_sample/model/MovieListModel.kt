package com.denny.epoxy_sample.model

import android.util.Log
import com.denny.epoxy_sample.api.RetrofitManager
import com.denny.epoxy_sample.bean.BaseList
import com.denny.epoxy_sample.bean.MovieListResponse
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * author: Denny
 * created on: 2022/3/2 上午 11:31
 */
class MovieListModel {
    interface OnDataReadyCallback {
        fun onDataReady(result: ArrayList<MovieListResponse>?)
    }

    fun changeData(callback: OnDataReadyCallback) {

        CoroutineScope(Dispatchers.IO).launch {

            val apiService = RetrofitManager.mInstance.myAPIService
            var result: ArrayList<MovieListResponse>? = null
            apiService.Get_popular_list().enqueue(object : Callback<BaseList<MovieListResponse>> {
                override fun onResponse(
                    call: Call<BaseList<MovieListResponse>>,
                    response: Response<BaseList<MovieListResponse>>
                ) {
                    Log.e("onResponse", response.code().toString() + "" + response.message())
                    result = response.body()?.results!!
                    GlobalScope.launch(Dispatchers.Main){
                        callback.onDataReady(result)
                    }


                }

                override fun onFailure(call: Call<BaseList<MovieListResponse>>, t: Throwable) {
                    Log.e("onFailure", "" + t.message)
                }
            })

        }
    }
}
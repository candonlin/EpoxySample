package com.denny.epoxy_sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denny.epoxy_sample.bean.MovieListResponse
import com.denny.epoxy_sample.model.MovieListModel

/**
 * author: Denny
 * created on: 2022/3/2 上午 11:26
 */
class MainViewModel : ViewModel() {
    val movieListModel = MovieListModel()
//    var popularList = ArrayList<MovieListResponse>()
    var popularList = MutableLiveData<ArrayList<MovieListResponse>>()

    fun getData() {
        movieListModel.changeData(object : MovieListModel.OnDataReadyCallback {
            override fun onDataReady(result: ArrayList<MovieListResponse>?) {
                popularList.value=result
            }
        })
    }
}
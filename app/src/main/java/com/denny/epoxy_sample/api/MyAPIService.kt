package com.denny.epoxy_sample.api

import com.denny.epoxy_sample.bean.BaseList
import com.denny.epoxy_sample.bean.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * author: Denny
 * created on: 2022/3/2 上午 09:37
 */
interface MyAPIService {
    @GET("movie/popular")
    fun Get_popular_list(): Call<BaseList<MovieListResponse>>;

}
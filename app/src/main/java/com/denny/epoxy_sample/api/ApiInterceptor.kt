package com.denny.epoxy_sample.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 * author: Denny
 * created on: 2022/3/2 下午 12:05
 */
class ApiInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", "11ecb6476171b519ae3e353d0c349fbc")
            .addQueryParameter("language","zh-TW")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
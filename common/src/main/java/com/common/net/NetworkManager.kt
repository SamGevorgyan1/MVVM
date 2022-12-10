package com.common.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> createWebService(baseUrl: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}

interface ResultCallback<T> {

    fun onSuccess(data: T)

    fun onError(msg: String) {}
}
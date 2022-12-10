package com.guardian.news.api

import com.guardian.model.news.GuardianNewsDto
import com.guardian.utils.GuardianConstants.NEWS_API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("search")

    fun getNews(@Query("api-key") apiKey: String = NEWS_API_KEY): Call<GuardianNewsDto>



}
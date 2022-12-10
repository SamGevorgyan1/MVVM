package com.guardian.news.repository

import com.common.net.ResultCallback
import com.guardian.model.news.GuardianNewsDto

import com.guardian.news.api.NewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NewsRepository {
    fun getNews(resultCallback: ResultCallback<GuardianNewsDto?>)
}

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override fun getNews(resultCallback: ResultCallback<GuardianNewsDto?>) {

        newsApi.getNews().enqueue(object : Callback<GuardianNewsDto> {
            override fun onResponse(
                call: Call<GuardianNewsDto>,
                response: Response<GuardianNewsDto>
            ) {
                if (response.isSuccessful) resultCallback.onSuccess(response.body())
                else resultCallback.onError(response.body().toString())
            }

            override fun onFailure(call: Call<GuardianNewsDto>, t: Throwable) {
                resultCallback.onError(t.message ?: "unknown failure")
            }
        })
    }

}


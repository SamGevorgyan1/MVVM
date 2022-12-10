package com.guardian.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.common.net.ResultCallback
import com.guardian.model.news.GuardianNewsDto
import com.guardian.model.news.NewsResultDto
import com.guardian.news.repository.NewsRepository


abstract class BaseNewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _resultsLiveData: MutableLiveData<List<NewsResultDto>?> = MutableLiveData()
    val resultsLiveData: LiveData<List<NewsResultDto>?>
        get() = _resultsLiveData

    fun getNews() {
        repository.getNews(
            object : ResultCallback<GuardianNewsDto?> {
                override fun onSuccess(data: GuardianNewsDto?) {
                    _resultsLiveData.value = data?.response?.results
                }
            })
    }
}
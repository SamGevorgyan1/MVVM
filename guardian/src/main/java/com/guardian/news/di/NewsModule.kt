package com.guardian.news.di

import com.common.net.createWebService
import com.guardian.news.api.NewsApi
import com.guardian.news.repository.NewsRepository
import com.guardian.news.repository.NewsRepositoryImpl
import com.guardian.utils.GuardianConstants
import org.koin.dsl.module

fun newsModule() = module {

    single { createWebService<NewsApi>(GuardianConstants.BASE_URL) }

    single<NewsRepository> { NewsRepositoryImpl(get()) }


}




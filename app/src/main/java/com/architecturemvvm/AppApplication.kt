package com.architecturemvvm

import com.architecturemvvm.di.appModule
import com.common.BaseCommonApplication
import com.guardian.news.di.newsModule
import org.koin.core.module.Module

class AppApplication: BaseCommonApplication() {
    override fun getKoinModules(): List<Module> = listOf(newsModule(), appModule)
}
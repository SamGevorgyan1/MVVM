package com.architecturemvvm.di


import com.architecturemvvm.ui.news.viewModel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module

val appModule = module {

    viewModel { NewsViewModel(get()) }

}
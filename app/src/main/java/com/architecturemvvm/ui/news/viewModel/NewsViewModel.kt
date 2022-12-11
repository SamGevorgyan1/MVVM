package com.architecturemvvm.ui.news.viewModel

import com.guardian.news.BaseNewsViewModel
import com.guardian.news.repository.NewsRepository

class NewsViewModel(repositoryNews: NewsRepository): BaseNewsViewModel(repositoryNews)



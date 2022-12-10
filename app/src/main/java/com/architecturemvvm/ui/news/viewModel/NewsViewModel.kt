package com.architecturemvvm.ui.news.viewModel

import com.guardian.news.BaseNewsViewModel
import com.guardian.news.repository.NewsRepository

class NewsViewModel(repository: NewsRepository): BaseNewsViewModel(repository)



package com.architecturemvvm.ui.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.architecturemvvm.R
import com.architecturemvvm.databinding.FragmentNewsBinding
import com.architecturemvvm.ui.news.adapter.NewsAdapter
import com.architecturemvvm.ui.news.viewModel.NewsViewModel
import com.common.BaseCommonFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by viewModel<NewsViewModel>()
    private val newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getNews()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()

        viewModel.resultsLiveData.observe(viewLifecycleOwner) {
            newsAdapter.updateData(it)
        }
    }

    private fun setupViews(){
        binding.recyclerView.adapter = newsAdapter
    }

    private fun setupListeners(){

        binding.backButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_newsFragment_to_mainFragment)
        }
    }
}





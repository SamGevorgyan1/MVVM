package com.architecturemvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.architecturemvvm.R
import com.architecturemvvm.databinding.FragmentMainBinding
import com.common.BaseCommonFragment
import kotlin.system.exitProcess


class MainFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {

        binding.seeNewsButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_mainFragment_to_newsFragment)
        }

        binding.exitButton.setOnClickListener {
            exitProcess(0)
        }

    }
}
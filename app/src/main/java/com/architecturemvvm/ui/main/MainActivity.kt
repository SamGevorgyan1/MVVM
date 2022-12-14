package com.architecturemvvm.ui.main

import android.os.Bundle
import com.architecturemvvm.databinding.ActivityMainBinding
import com.common.BaseCommonActivity

class MainActivity : BaseCommonActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}


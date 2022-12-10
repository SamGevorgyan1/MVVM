package com.architecturemvvm.ui.main

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

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

        private fun checkForInternet(context: Context): Boolean {


            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val network = connectivityManager.activeNetwork ?: return false

                val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

                return when {

                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true


                    else -> false
                }
            } else {

                @Suppress("DEPRECATION") val networkInfo =
                    connectivityManager.activeNetworkInfo ?: return false
                @Suppress("DEPRECATION")
                return networkInfo.isConnected
            }
        }

}


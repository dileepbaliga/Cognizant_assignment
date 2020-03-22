package com.example.jsonparsingapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.Fragment

fun Fragment.isNetworkAvailable(): Boolean {
    val connectivityManager =
        this.activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}

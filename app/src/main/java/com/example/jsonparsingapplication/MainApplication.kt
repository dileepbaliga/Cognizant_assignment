package com.example.jsonparsingapplication

import android.app.Application
import com.example.jsonparsingapplication.di.FactsModule
import com.example.jsonparsingapplication.di.NetworkModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(FactsModule, NetworkModule))
        }
    }
}
package com.example.flightsearch

import android.app.Application
import com.example.flightsearch.di.AppContainer
import com.example.flightsearch.di.DefaultAppContainer

class FlightSearchApplication : Application() {

    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer(this)
    }
}
package com.example.flightsearch.di

import com.example.flightsearch.data.repository.AppRepository

interface AppContainer {

    val appRepository: AppRepository
}
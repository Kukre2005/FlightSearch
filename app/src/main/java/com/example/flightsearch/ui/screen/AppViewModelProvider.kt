package com.example.flightsearch.ui.screen

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApplication
import com.example.flightsearch.ui.screen.Flight.FlightsViewModel
import com.example.flightsearch.ui.screen.main.MainViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            MainViewModel(
                application().appContainer.appRepository
            )
        }

        initializer {
            FlightsViewModel(
                this.createSavedStateHandle(),
                application().appContainer.appRepository
            )
        }
    }
}

fun CreationExtras.application(): FlightSearchApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightSearchApplication)
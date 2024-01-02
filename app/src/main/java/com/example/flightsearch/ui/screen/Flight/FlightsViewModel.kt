package com.example.flightsearch.ui.screen.Flight

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.local.SavableFlightProvider
import com.example.flightsearch.data.local.room.FavoriteFlight
import com.example.flightsearch.data.local.room.SavableFlight
import com.example.flightsearch.data.repository.AppRepository
import com.example.flightsearch.ui.navigation.Route
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FlightsViewModel(
    savedStateHandle: SavedStateHandle,
    private val appRepository: AppRepository
) : ViewModel() {

    val airportCode: String = savedStateHandle[Route.Flights.A1_STRING_AIRPORT_ID] ?: ""

    private val savableFlights = MutableStateFlow(emptyList<SavableFlight>())
    private val favoritesFlights = appRepository.getFavoriteFlightsStream()
    private val combinedData: Flow<List<SavableFlight>> =
        combine(
            savableFlights,
            favoritesFlights
        ) { flights, favorites ->
            flights.map { flight ->
                val isFavorite = favorites.find { it.id == flight.id } != null
                flight.copy(isFavorite = isFavorite)
            }
        }

    val flights: StateFlow<List<SavableFlight>> =
        combinedData.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    init {
        savableFlights.value = SavableFlightProvider.savableFlights[airportCode] ?: emptyList()
    }

    fun onFavoriteClick(flight: FavoriteFlight) {
        viewModelScope.launch {
            val found = appRepository.getFavoriteFlight(flight.id)
            if (found == null) {
                appRepository.saveFavoriteFlight(flight)
            } else {
                appRepository.deleteFavoriteFlight(flight)
            }
        }
    }
}
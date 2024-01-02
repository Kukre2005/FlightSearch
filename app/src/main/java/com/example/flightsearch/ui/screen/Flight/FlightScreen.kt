package com.example.flightsearch.ui.screen.Flight

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.R
import com.example.flightsearch.ui.components.FlightsView
import com.example.flightsearch.ui.screen.AppViewModelProvider

@Composable
fun FlightsScreen(
    viewModel: FlightsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val flights = viewModel.flights.collectAsState().value
    FlightsView(
        title = stringResource(R.string.flights_from_code, viewModel.airportCode),
        list = flights,
        onFavoriteClick = viewModel::onFavoriteClick
    )
}
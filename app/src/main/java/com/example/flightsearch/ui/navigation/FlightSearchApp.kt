package com.example.flightsearch.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flightsearch.ui.screen.Flight.FlightsScreen
import com.example.flightsearch.ui.screen.main.MainScreen

@Composable
fun FlightSearchApp() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.MAIN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Route.MAIN) {
                MainScreen(
                    navigateToFlights = { airportCode ->
                        navController.navigate(
                            Route.Flights.createRoute(airportCode)
                        ) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(
                route = Route.Flights.ROUTE,
                arguments = listOf(
                    navArgument(Route.Flights.A1_STRING_AIRPORT_ID) {
                        type = NavType.StringType
                    }
                )
            ) {
                FlightsScreen()
            }
        }
    }
}
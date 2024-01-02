package com.example.flightsearch.data.local.source

import com.example.flightsearch.data.local.datastore.LocalSearchDataSource
import com.example.flightsearch.data.local.room.FlightsDao

interface LocalDataSource : LocalSearchDataSource, FlightsDao
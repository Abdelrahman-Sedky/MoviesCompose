package com.example.movies

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.movies.screen.booking.bookingRoute
import com.example.movies.screen.details.detailsRoute
import com.example.movies.screen.home.homeRoute


@Composable
fun MoviesNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        homeRoute(navController = navController)
        detailsRoute(navController = navController)
        bookingRoute(navController = navController)
    }

}
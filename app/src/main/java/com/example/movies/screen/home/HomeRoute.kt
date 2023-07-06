package com.example.movies.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val Route = "home"
fun NavGraphBuilder.homeRoute(
    navController: NavController
) {
    composable(Route) {
        HomeScreen(navController = navController)
    }
}
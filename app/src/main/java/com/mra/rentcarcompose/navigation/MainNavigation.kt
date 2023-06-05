package com.mra.rentcarcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mra.rentcarcompose.screen.BookingCarScreen
import com.mra.rentcarcompose.screen.CarsListScreen
import com.mra.rentcarcompose.screen.LoginScreen
import com.mra.rentcarcompose.utils.requiredArg


@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LOGIN_SCREEN_ROUTE) {
        composable(LOGIN_SCREEN_ROUTE) { LoginScreen(navController) }

        composable(CARS_LIST_SCREEN_ROUTE) { CarsListScreen(navController) }

        composable(
            route = BOOKING_CAR_SCREEN_ROUTE,
            arguments = listOf(navArgument(CAR_DATA_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) {
            BookingCarScreen(navController, it.requiredArg(CAR_DATA_ARGUMENT_KEY))
        }
    }
}
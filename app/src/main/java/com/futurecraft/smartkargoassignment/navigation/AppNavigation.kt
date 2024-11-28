package com.futurecraft.smartkargoassignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.futurecraft.smartkargoassignment.constants.Constants.PRODUCTS_DESTINATION
import com.futurecraft.smartkargoassignment.ui.products.ProductScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PRODUCTS_DESTINATION) {
        composable(route = PRODUCTS_DESTINATION) { ProductScreen() }
    }
}
package com.demo.kotlin_compose.Compose

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed class Router(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Login : Router("home")

//    data object PlantDetail : Router(
//        route = "plantDetail/{plantId}",
//        navArguments = listOf(navArgument("plantId") {
//            type = NavType.StringType
//        })
//    ) {
//        fun createRoute(plantId: String) = "plantDetail/${plantId}"
//    }


}
package com.demo.kotlin_compose.Compose

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed class Router(
    val route: String,                                      //路径
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Login : Router("login")

    data object Home : Router("home")

//    data object PlantDetail : Router(
//        route = "plantDetail/{plantId}",
//        navArguments = listOf(navArgument("plantId") {
//            type = NavType.StringType
//        })
//    ) {
//        fun createRoute(plantId: String) = "plantDetail/${plantId}"
//    }


}
package com.demo.kotlin_compose.Compose

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.demo.kotlin_compose.Activity.HomeActivity


/*
        切换不同页面 navigation
 */
@Composable
fun ComposeDemoApp() {
    val navController = rememberNavController()
    ComposeDemoNavHost(
        navController = navController
    )
}


@Composable
fun ComposeDemoNavHost(
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = Router.Login.route) {
        composable(route = Router.Login.route) {
            LoginScreen(
                onLoginClick = {
//                    navController.navigate("")
                    val intent = Intent(context,HomeActivity::class.java)
                    activity.startActivity(intent)

//                    val uri = Uri.parse("url")
//                    val intent = Intent(Intent.ACTION_VIEW, uri)
//                    activity.startActivity(intent)
                }
            )
        }
//        composable(
//            route = Router.PlantDetail.route,
//            arguments = Router.PlantDetail.navArguments
//        ) {
//            PlantDetailsScreen(
//                onBackClick = { navController.navigateUp() },
//
//                onGalleryClick = {
//                    navController.navigate(
//                        Screen.Gallery.createRoute(
//                            plantName = it.name
//                        )
//                    )
//                }
//            )
//        }


    }
}
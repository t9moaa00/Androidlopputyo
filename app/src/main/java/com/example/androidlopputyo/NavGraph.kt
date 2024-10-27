package com.example.androidlopputyo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidlopputyo.ui.screens.MainScreen
import com.example.androidlopputyo.ui.screens.InfoScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainScreen(navController)
        }
        composable(Screen.Info.route) {
            InfoScreen(navController)
        }
    }
}

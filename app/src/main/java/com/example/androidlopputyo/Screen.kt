package com.example.androidlopputyo.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Info : Screen("info")
}

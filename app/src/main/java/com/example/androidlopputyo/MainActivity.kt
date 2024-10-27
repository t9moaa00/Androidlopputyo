package com.example.androidlopputyo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.androidlopputyo.navigation.NavGraph
import com.example.androidlopputyo.ui.theme.AndroidlopputyoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidlopputyoTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

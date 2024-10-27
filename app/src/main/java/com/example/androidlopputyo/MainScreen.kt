package com.example.androidlopputyo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androidlopputyo.omaviewmodel.MainViewModel
import com.example.androidlopputyo.R
import com.example.androidlopputyo.navigation.Screen


@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = viewModel()) {
    val catFact by viewModel.catFact.collectAsState()
    val loading by viewModel.loading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.main_screen_title))

        if (loading) {
            CircularProgressIndicator()
        } else {
            Text(text = catFact)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.getNewCatFact() }) {
                Text(text = stringResource(R.string.get_fact_button))
            }
        }

        Button(onClick = { navController.navigate(Screen.Info.route) }) {
            Text(text = stringResource(R.string.info_screen_title))
        }
    }
}

package com.example.todolistkmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistkmp.presentation.components.MainScreen
import com.example.todolistkmp.presentation.components.StatsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Tasks.route
    ) {
        composable(Screens.Tasks.route) {
            MainScreen(
                onNavigateToStats = { navController.navigate(Screens.Stats.route) }
            )
        }
        composable(Screens.Stats.route) {
            StatsScreen(
                onBack = { navController.navigate(Screens.Tasks.route) }
            )
        }
    }
}

package com.example.todolistkmp.navigation

sealed class Screens(val route: String) {
    data object Tasks : Screens("tasks")
    data object Stats : Screens("stats")
}
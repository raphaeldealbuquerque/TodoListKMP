package com.raphaeldealbuquerque.todolistkmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.raphaeldealbuquerque.todolistkmp.navigation.NavGraph

@Composable
fun App() {
    MaterialTheme {
        NavGraph()
    }
}
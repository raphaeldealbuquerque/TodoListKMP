package com.raphaeldealbuquerque.todolistkmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.raphaeldealbuquerque.todolistkmp.injection.appModule
import com.raphaeldealbuquerque.todolistkmp.navigation.NavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(appModule)
        }
    )
    {
        MaterialTheme {
            NavGraph()
        }
    }
}
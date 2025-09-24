package com.example.todolistkmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.todolistkmp.injection.appModule
import com.example.todolistkmp.navigation.NavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
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
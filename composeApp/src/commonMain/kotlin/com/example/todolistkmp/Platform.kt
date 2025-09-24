package com.example.todolistkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
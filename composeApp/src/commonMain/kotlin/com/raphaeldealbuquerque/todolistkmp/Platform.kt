package com.raphaeldealbuquerque.todolistkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
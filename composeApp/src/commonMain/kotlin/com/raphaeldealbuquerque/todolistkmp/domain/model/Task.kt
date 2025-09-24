package com.raphaeldealbuquerque.todolistkmp.model

data class Task(
    val id: String,
    val title: String,
    val done: Boolean = false
)

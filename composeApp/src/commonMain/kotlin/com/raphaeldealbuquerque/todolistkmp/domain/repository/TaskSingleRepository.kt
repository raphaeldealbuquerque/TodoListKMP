package com.raphaeldealbuquerque.todolistkmp.domain.repository

import com.raphaeldealbuquerque.todolistkmp.model.Task

interface TaskSingleRepository {
    fun add(todo: Task)
    fun remove(id: String)
    fun all(): List<Task>
}
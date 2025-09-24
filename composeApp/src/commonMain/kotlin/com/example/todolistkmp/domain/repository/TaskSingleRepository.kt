package com.example.todolistkmp.domain.repository

import com.example.todolistkmp.model.Task

interface TaskSingleRepository {
    fun add(todo: Task)
    fun remove(id: String)
    fun all(): List<Task>
}
package com.example.todolistkmp.data.repository

import com.example.todolistkmp.domain.repository.TaskFactoryRepository
import com.example.todolistkmp.domain.repository.TaskRepository
import com.example.todolistkmp.domain.repository.TaskSingleRepository
import com.example.todolistkmp.model.Task

class TaskRepositoryImpl() : TaskRepository {
    private val items = mutableListOf<Task>()
    override fun add(todo: Task) { items.add(todo) }
    override fun remove(id: String) { items.removeAll { it.id == id } }
    override fun all(): List<Task> = items.toList()
}
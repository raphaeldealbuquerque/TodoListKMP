package com.raphaeldealbuquerque.todolistkmp.data.repository

import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskFactoryRepository
import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository
import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskSingleRepository
import com.raphaeldealbuquerque.todolistkmp.model.Task

class TaskRepositoryImpl() : TaskRepository {
    private val items = mutableListOf<Task>()
    override fun add(todo: Task) { items.add(todo) }
    override fun remove(id: String) { items.removeAll { it.id == id } }
    override fun all(): List<Task> = items.toList()
}
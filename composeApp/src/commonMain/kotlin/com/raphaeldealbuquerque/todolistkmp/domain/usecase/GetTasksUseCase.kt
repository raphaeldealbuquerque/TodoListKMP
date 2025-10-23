package com.raphaeldealbuquerque.todolistkmp.domain.usecase

import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository
import com.raphaeldealbuquerque.todolistkmp.model.Task

class GetTasksUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(): List<Task> = repository.all()
}
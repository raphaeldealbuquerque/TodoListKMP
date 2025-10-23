package com.raphaeldealbuquerque.todolistkmp.domain.usecase

import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository
import com.raphaeldealbuquerque.todolistkmp.model.Task
import com.raphaeldealbuquerque.todolistkmp.randomString

class AddTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(title: String) {
        repository.add(Task(randomString(), title))
    }
}
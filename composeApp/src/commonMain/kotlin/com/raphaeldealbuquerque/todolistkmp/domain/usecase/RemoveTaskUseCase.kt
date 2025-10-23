package com.raphaeldealbuquerque.todolistkmp.domain.usecase

import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository

class RemoveTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(id: String) {
        repository.remove(id)
    }
}
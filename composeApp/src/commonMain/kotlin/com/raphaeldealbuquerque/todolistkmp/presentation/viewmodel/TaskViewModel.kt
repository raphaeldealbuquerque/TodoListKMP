package com.raphaeldealbuquerque.todolistkmp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository
import com.raphaeldealbuquerque.todolistkmp.domain.usecase.AddTaskUseCase
import com.raphaeldealbuquerque.todolistkmp.domain.usecase.GetTasksUseCase
import com.raphaeldealbuquerque.todolistkmp.domain.usecase.RemoveTaskUseCase
import com.raphaeldealbuquerque.todolistkmp.model.Task
import com.raphaeldealbuquerque.todolistkmp.randomString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val removeTaskUseCase: RemoveTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase
): ViewModel() {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    init {
        loadTasks()
    }

    fun addTask(title: String) {
        scope.launch {
            addTaskUseCase(title)
            loadTasks()
        }
    }

    fun removeTask(id: String) {
        scope.launch {
            removeTaskUseCase(id)
            loadTasks()
        }
    }

    private fun loadTasks() {
        scope.launch {
            _tasks.value = getTasksUseCase()
        }
    }
}
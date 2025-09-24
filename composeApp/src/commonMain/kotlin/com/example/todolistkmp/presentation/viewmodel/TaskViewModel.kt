package com.example.todolistkmp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolistkmp.domain.repository.TaskRepository
import com.example.todolistkmp.model.Task
import com.example.todolistkmp.randomString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel constructor(
  private val repository: TaskRepository
): ViewModel() {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    init {
        loadTasks()
    }

    fun addTask(title: String) {
        scope.launch {
            repository.add(Task(randomString(), title))
            loadTasks()
        }
    }

    fun removeTask(id: String) {
        scope.launch {
            repository.remove(id)
            loadTasks()
        }
    }

    private fun loadTasks() {
        scope.launch {
            _tasks.value = repository.all()
        }
    }
}
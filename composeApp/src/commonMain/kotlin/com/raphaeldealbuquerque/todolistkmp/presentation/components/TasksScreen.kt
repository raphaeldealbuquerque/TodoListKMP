package com.raphaeldealbuquerque.todolistkmp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.raphaeldealbuquerque.todolistkmp.model.Task
import com.raphaeldealbuquerque.todolistkmp.presentation.viewmodel.TaskViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    onNavigateToStats: () -> Unit = {}
) {
    val viewModel: TaskViewModel = koinViewModel()
    val tasks by viewModel.tasks.collectAsState()
    TaskListContent(
        tasks = tasks,
        onAddTask = { title -> viewModel.addTask(title) },
        onRemoveTask = { id -> viewModel.removeTask(id) },
        onNavigateToStats = onNavigateToStats
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListContent(
    tasks: List<Task> = emptyList(),
    onAddTask: (String) -> Unit = {},
    onRemoveTask: (String) -> Unit = {},
    onNavigateToStats: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    modifier = Modifier.background(Color.White),
                    title = { Text("Lista de Tarefas") },
                    actions = {
                        IconButton(onClick = onNavigateToStats) {
                            Icon(Icons.Default.Info, contentDescription = "Estatísticas")
                        }
                    },
                    colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Nova tarefa") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = {
                        if (text.isNotBlank()) {
                            onAddTask(text)
                            text = ""
                        }
                    }) { Text("Adicionar") }
                }

                Spacer(Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(tasks) { task ->
                        TaskItem(
                            task = task,
                            onRemoveTask = onRemoveTask
                        )
                    }
                }
            }
        }
    }
}

@Composable
expect fun TaskItem(
    task: Task,
    onRemoveTask: (String) -> Unit
)

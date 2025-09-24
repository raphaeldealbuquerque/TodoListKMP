package com.example.todolistkmp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Delete
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
import androidx.compose.ui.unit.dp
import com.example.todolistkmp.model.Task
import com.example.todolistkmp.presentation.viewmodel.TaskViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
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
private fun TaskListContent(
    tasks: List<Task> = emptyList(),
    onAddTask: (String) -> Unit = {},
    onRemoveTask: (String) -> Unit = {},
    onNavigateToStats: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                TopAppBar(
                    title = { Text("Lista de Tarefas") },
                    actions = {
                        IconButton(onClick = onNavigateToStats) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Estatísticas"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                Row {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Nova tarefa") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        if (text.isNotBlank()) {
                            onAddTask(text)
                            text = ""
                        }
                    }) {
                        Text("Adicionar")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(tasks) { task ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(task.title)
                            IconButton(onClick = {
                                onRemoveTask(task.id)
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "Remover"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TaskListContentPreview() {
    TaskListContent()
}
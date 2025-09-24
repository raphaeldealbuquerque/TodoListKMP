package com.example.todolistkmp.injection

import com.example.todolistkmp.data.repository.TaskRepositoryImpl
import com.example.todolistkmp.domain.repository.TaskRepository
import com.example.todolistkmp.presentation.viewmodel.TaskViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<TaskRepository>(named("single")) { TaskRepositoryImpl() }
    factory<TaskRepository>(named("factory")) { TaskRepositoryImpl() }

    viewModel<TaskViewModel> {
        TaskViewModel(repository = get(named("factory")))
    }
}

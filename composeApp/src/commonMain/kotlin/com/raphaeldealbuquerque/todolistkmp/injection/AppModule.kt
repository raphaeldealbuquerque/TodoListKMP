package com.raphaeldealbuquerque.todolistkmp.injection

import com.raphaeldealbuquerque.todolistkmp.data.repository.TaskRepositoryImpl
import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository
import com.raphaeldealbuquerque.todolistkmp.presentation.viewmodel.TaskViewModel
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

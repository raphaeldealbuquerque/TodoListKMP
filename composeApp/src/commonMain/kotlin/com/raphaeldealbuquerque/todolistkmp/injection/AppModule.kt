package com.raphaeldealbuquerque.todolistkmp.injection

import com.raphaeldealbuquerque.todolistkmp.data.repository.TaskRepositoryImpl
import com.raphaeldealbuquerque.todolistkmp.domain.repository.TaskRepository
import com.raphaeldealbuquerque.todolistkmp.domain.usecase.AddTaskUseCase
import com.raphaeldealbuquerque.todolistkmp.domain.usecase.GetTasksUseCase
import com.raphaeldealbuquerque.todolistkmp.domain.usecase.RemoveTaskUseCase
import com.raphaeldealbuquerque.todolistkmp.presentation.viewmodel.TaskViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<TaskRepository> { TaskRepositoryImpl() }

    factory { AddTaskUseCase(get()) }
    factory { RemoveTaskUseCase(get()) }
    factory { GetTasksUseCase(get()) }

    viewModel<TaskViewModel> {
        TaskViewModel(
            addTaskUseCase = get(),
            removeTaskUseCase = get(),
            getTasksUseCase = get()
        )
    }
}

val appModuleNamed = module {

    single<TaskRepository>(named("single")) { TaskRepositoryImpl() }
    factory<TaskRepository>(named("factory")) { TaskRepositoryImpl() }

    factory(named("singleAddUseCase")) { AddTaskUseCase(get(named("single"))) }
    factory(named("factoryAddUseCase")) { AddTaskUseCase(get(named("factory"))) }

    viewModel(named("singleViewModel")) {
        TaskViewModel(
            addTaskUseCase = get(named("singleAddUseCase")),
            removeTaskUseCase = RemoveTaskUseCase(get(named("single"))),
            getTasksUseCase = GetTasksUseCase(get(named("single")))
        )
    }

    viewModel(named("factoryViewModel")) {
        TaskViewModel(
            addTaskUseCase = get(named("factoryAddUseCase")),
            removeTaskUseCase = RemoveTaskUseCase(get(named("factory"))),
            getTasksUseCase = GetTasksUseCase(get(named("factory")))
        )
    }
}
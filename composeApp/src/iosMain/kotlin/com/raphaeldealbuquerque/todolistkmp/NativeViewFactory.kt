package com.raphaeldealbuquerque.todolistkmp

import com.raphaeldealbuquerque.todolistkmp.model.Task
import platform.UIKit.UIViewController

interface NativeViewFactory {
    companion object {
        lateinit var instance: NativeViewFactory
    }

    fun createTasksItem(
        task: Task,
        onRemoveTask: (String) -> Unit
    ): UIViewController
}
package com.raphaeldealbuquerque.todolistkmp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.UIKitInteropInteractionMode
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitViewController
import com.raphaeldealbuquerque.todolistkmp.NativeViewFactory
import com.raphaeldealbuquerque.todolistkmp.model.Task
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class, ExperimentalComposeUiApi::class)
@Composable
actual fun TaskItem(
    task: Task,
    onRemoveTask: (String) -> Unit
) {
    UIKitViewController(
        factory = { NativeViewFactory.instance.createTasksItem(task, onRemoveTask) },
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        properties = UIKitInteropProperties(
            interactionMode = UIKitInteropInteractionMode.NonCooperative,
            isNativeAccessibilityEnabled = true
        )
    )
}

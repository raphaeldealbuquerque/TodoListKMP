import Foundation
import SwiftUI
import UIKit
import ComposeApp

class IOSNativeViewFactory: NativeViewFactory {
    func createTasksItem(
        task: Task,
        onRemoveTask: @escaping (String) -> Void
    ) -> UIViewController {
        return UIHostingController(
            rootView: TaskItemView(taskTitle: task.title, onRemoveTask: { onRemoveTask(task.id) })
        )
    }
}

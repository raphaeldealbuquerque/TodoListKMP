import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        HelperKt.doInitKoin()
        NativeViewFactoryCompanion.shared.instance = IOSNativeViewFactory()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

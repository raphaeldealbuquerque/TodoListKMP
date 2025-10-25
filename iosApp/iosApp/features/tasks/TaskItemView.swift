import SwiftUI

struct TaskItemView: View {
    let taskTitle: String
    let onRemoveTask: () -> Void

    var body: some View {
        HStack {
            Text(taskTitle)
                .font(.system(size: 16, weight: .medium))
                .foregroundColor(.primary)
            Spacer()
        }
        .padding(.horizontal, 16)
        .frame(
            maxWidth: .infinity,
            minHeight: 64,
            idealHeight: 64,
            maxHeight: 64
        )
        .background(
            RoundedRectangle(cornerRadius: 12)
                .fill(Color(UIColor.secondarySystemBackground))
                .overlay(
                    RoundedRectangle(cornerRadius: 12)
                        .stroke(Color.gray.opacity(0.2), lineWidth: 1)
                )
                .shadow(color: Color.black.opacity(0.05), radius: 2, x: 0, y: 1)
        )
        .contextMenu {
            Button(role: .destructive) {
                onRemoveTask()
            } label: {
                Label("Remover", systemImage: "trash")
            }
        }
        .padding(.horizontal, 16)
    }
}


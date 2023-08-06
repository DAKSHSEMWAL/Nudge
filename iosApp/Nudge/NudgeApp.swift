//
//  NudgeApp.swift
//  Nudge
//
//  Created by Daksh Semwal on 07/08/23.
//

import SwiftUI
import Common

@main
struct NudgeApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        // File name "Main" + "Kt" -> "Function Name"
        return MainViewControllerKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
}

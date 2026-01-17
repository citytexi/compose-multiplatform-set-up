package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.share.app.Greeting
import org.example.project.share.ui.App

fun MainViewController() = ComposeUIViewController {
    App(
        greet = Greeting().greet(),
    )
}

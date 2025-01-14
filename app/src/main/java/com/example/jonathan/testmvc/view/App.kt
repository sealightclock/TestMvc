package com.example.jonathan.testmvc.view

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.jonathan.testmvc.controller.UserController

@Composable
fun App() {
    val controller = remember { UserController() }
    MaterialTheme {
        UserScreen(controller)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App()
}

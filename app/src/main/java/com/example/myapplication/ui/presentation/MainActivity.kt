package com.example.myapplication.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.ChatScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val viewModel: ChatViewModel by viewModels<ChatViewModel>()
                ChatScreen(viewModel = viewModel)
            }
        }
    }
}
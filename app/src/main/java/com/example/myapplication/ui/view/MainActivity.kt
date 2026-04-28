package com.example.myapplication.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.logik.ChatViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                val viewModel: ChatViewModel by viewModels<ChatViewModel>()

                NavHost(
                    startDestination = "ChatScreen",
                    navController = navController
                ) {
                    composable("ChatScreen") {
                        ChatScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
}
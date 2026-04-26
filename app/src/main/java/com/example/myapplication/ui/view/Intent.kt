package com.example.myapplication.ui.view

sealed class ChatIntent {
    object LoadData : ChatIntent()
    data class SendMessage(val text: String) : ChatIntent()
}
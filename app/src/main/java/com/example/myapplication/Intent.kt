package com.example.myapplication

sealed class ChatIntent {
    object LoadData : ChatIntent()
    data class SendMessage(val text: String) : ChatIntent()
}
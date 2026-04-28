package com.example.myapplication.logik

sealed class ChatIntent {
    object LoadData : ChatIntent()
    data class SendMessage(val text: String) : ChatIntent()
}
package com.example.myapplication.model

data class Message(
    val id: Int,
    val text: String,
    val isSentByMe: Boolean
)

sealed class ChatState {
    object Loading : ChatState()
    data class Success(val messages: List<Message>) : ChatState()
    data class Error(val message: String) : ChatState()
}
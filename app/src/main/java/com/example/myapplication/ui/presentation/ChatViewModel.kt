package com.example.myapplication.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ChatIntent
import com.example.myapplication.model.ChatState
import com.example.myapplication.model.Message
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val _state = MutableStateFlow<ChatState>(ChatState.Loading)
    val state: StateFlow<ChatState> = _state.asStateFlow()

    private val _intentFlow = MutableSharedFlow<ChatIntent>()

    init {
        processIntents()
    }

    private fun processIntents() {
        viewModelScope.launch {
            _intentFlow.collect { intent ->
                processIntent(intent)
            }
        }
    }

    fun processIntent(intent: ChatIntent) {
        when (intent) {
            is ChatIntent.LoadData -> loadData()
            is ChatIntent.SendMessage -> sendMessage(intent.text)
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = try {
                val data = listOf(
                    Message(id = 1, text = "Привет!", isSentByMe = false),
                    Message(id = 2, text = "Как дела?", isSentByMe = true)
                )
                ChatState.Success(data)
            } catch (e: Exception) {
                ChatState.Error("Не удалось загрузить сообщения")
            }
        }
    }

    private fun sendMessage(text: String) {
        _state.update { currentState ->
            when (currentState) {
                is ChatState.Success -> {
                    val newMessage = Message(
                        id = currentState.messages.size + 1,
                        text = text,
                        isSentByMe = true
                    )
                    ChatState.Success(currentState.messages + newMessage)
                }
                else -> currentState
            }
        }
    }
}
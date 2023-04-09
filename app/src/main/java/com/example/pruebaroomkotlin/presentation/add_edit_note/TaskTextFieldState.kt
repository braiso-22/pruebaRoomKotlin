package com.example.pruebaroomkotlin.presentation.add_edit_note

data class TaskTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
)
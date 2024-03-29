package com.example.pruebaroomkotlin.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed class AddEditTaskEvent{
    data class EnteredTitle(val value: String): AddEditTaskEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditTaskEvent()
    data class EnteredContent(val value: String): AddEditTaskEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddEditTaskEvent()
    object SaveTask: AddEditTaskEvent()
}
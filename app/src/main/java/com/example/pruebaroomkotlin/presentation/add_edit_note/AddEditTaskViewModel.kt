package com.example.pruebaroomkotlin.presentation.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaroomkotlin.feature_tareas.domain.model.InvalidTaskException
import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.use_case.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _taskTitle = mutableStateOf(
        TaskTextFieldState(
            hint = "Enter title..."
        )
    )
    val taskTitle: State<TaskTextFieldState> = _taskTitle

    private val _taskContent = mutableStateOf(
        TaskTextFieldState(
            hint = "Enter content..."
        )
    )
    val taskContent: State<TaskTextFieldState> = _taskContent

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentTaskId: Int? = null

    init {
        savedStateHandle.get<Int>("taskId")?.let { taskId ->
            if (taskId != -1) {
                viewModelScope.launch {
                    taskUseCases.getTask(taskId)?.also { task ->
                        currentTaskId = task.id
                        _taskTitle.value = taskTitle.value.copy(
                            text = task.name,
                            isHintVisible = false,
                        )
                        _taskContent.value = taskContent.value.copy(
                            text = task.content,
                            isHintVisible = false,
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditTaskEvent) {
        when (event) {
            is AddEditTaskEvent.EnteredTitle -> {
                _taskTitle.value = taskTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditTaskEvent.ChangeTitleFocus -> {
                _taskTitle.value = taskTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused && taskTitle.value.text.isBlank()
                )
            }
            is AddEditTaskEvent.EnteredContent -> {
                _taskContent.value = taskContent.value.copy(
                    text = event.value
                )
            }
            is AddEditTaskEvent.ChangeContentFocus -> {
                _taskContent.value = taskContent.value.copy(
                    isHintVisible = !event.focusState.isFocused && taskContent.value.text.isBlank()
                )
            }
            is AddEditTaskEvent.SaveTask -> {
                viewModelScope.launch {
                    try {
                        taskUseCases.createTask(
                            Task(
                                id = currentTaskId,
                                name = taskTitle.value.text,
                                content = taskContent.value.text,
                                timeStamp = System.currentTimeMillis(),
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveTask)
                    } catch (e: InvalidTaskException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                message = e.message ?: "Couldn't save task"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SaveTask : UiEvent()
    }
}
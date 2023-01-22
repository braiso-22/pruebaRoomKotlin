package com.example.pruebaroomkotlin.presentation.tasks

import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.util.TaskOrder

sealed class TasksEvent {
    data class Order(val taskOrder: TaskOrder) : TasksEvent()
    data class DeleteTask(val task: Task) : TasksEvent()
    object RestoreTask : TasksEvent()
    object ToggleOrderSection : TasksEvent()
}

package com.example.pruebaroomkotlin.presentation.tasks

import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.util.OrderType
import com.example.pruebaroomkotlin.feature_tareas.domain.util.TaskOrder

data class TasksState(
    val tasks: List<Task> = emptyList(),
    val taskOrder: TaskOrder = TaskOrder.Timestamp(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
    )

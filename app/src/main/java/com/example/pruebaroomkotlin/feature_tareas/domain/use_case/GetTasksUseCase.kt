package com.example.pruebaroomkotlin.feature_tareas.domain.use_case

import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.repository.TaskRepository
import com.example.pruebaroomkotlin.feature_tareas.domain.util.OrderType
import com.example.pruebaroomkotlin.feature_tareas.domain.util.TaskOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTasksUseCase(
    private val repository: TaskRepository
) {
    operator fun invoke(
        taskOrder: TaskOrder = TaskOrder.Timestamp(OrderType.Ascending)
    ): Flow<List<Task>> {
        return repository.getTasks().map { tasks ->
            when (taskOrder.orderType) {
                is OrderType.Ascending -> {
                    when (taskOrder) {
                        is TaskOrder.Timestamp -> tasks.sortedBy { it.timeStamp }
                        is TaskOrder.Name -> tasks.sortedBy { it.name.lowercase() }
                    }
                }
                is OrderType.Descending -> {
                    when (taskOrder) {
                        is TaskOrder.Timestamp -> tasks.sortedByDescending { it.timeStamp }
                        is TaskOrder.Name -> tasks.sortedByDescending { it.name.lowercase() }
                    }
                }
            }
        }
    }
}
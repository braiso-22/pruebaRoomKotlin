package com.example.pruebaroomkotlin.feature_tareas.domain.use_case

import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.repository.TaskRepository

class DeleteTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task){
        repository.deleteTask(task)
    }
}
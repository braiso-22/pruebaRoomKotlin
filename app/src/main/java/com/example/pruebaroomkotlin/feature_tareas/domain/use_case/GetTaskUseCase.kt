package com.example.pruebaroomkotlin.feature_tareas.domain.use_case

import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.repository.TaskRepository

class GetTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id: Int): Task? {
        return repository.getTaskById(id)
    }
}
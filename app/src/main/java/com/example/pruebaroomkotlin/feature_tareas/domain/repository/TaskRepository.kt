package com.example.pruebaroomkotlin.feature_tareas.domain.repository

import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun getTaskById(id: Int): Task?
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
}
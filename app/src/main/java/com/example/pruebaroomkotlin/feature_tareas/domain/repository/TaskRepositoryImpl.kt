package com.example.pruebaroomkotlin.feature_tareas.domain.repository

import com.example.pruebaroomkotlin.feature_tareas.data.data_source.TaskDao
import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {
    override fun getTasks(): Flow<List<Task>> {
        return dao.getTasks()
    }

    override suspend fun getTaskById(id: Int): Task? {
        return  dao.getTaskById(id)
    }

    override suspend fun insertTask(task: Task) {
        dao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task)
    }

}
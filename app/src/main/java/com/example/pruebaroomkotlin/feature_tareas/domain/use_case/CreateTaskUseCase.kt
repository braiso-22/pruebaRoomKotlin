package com.example.pruebaroomkotlin.feature_tareas.domain.use_case

import com.example.pruebaroomkotlin.feature_tareas.domain.model.InvalidTaskException
import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task
import com.example.pruebaroomkotlin.feature_tareas.domain.repository.TaskRepository

class CreateTaskUseCase(
    private val repository: TaskRepository
) {
    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(
        task: Task
    ) {
        if(task.name.isBlank()){
            throw InvalidTaskException("The name of the task can't be empty")
        }
        if(task.content.isBlank()){
            throw InvalidTaskException("The name of the task can't be empty")
        }
        repository.insertTask(task)
    }
}
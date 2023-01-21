package com.example.pruebaroomkotlin.feature_tareas.domain.use_case

data class TaskUseCases(
    val getTasks: GetTasksUseCase,
    val deleteTask : DeleteTaskUseCase
)

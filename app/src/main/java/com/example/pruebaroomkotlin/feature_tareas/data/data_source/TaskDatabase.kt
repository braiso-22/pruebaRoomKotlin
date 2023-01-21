package com.example.pruebaroomkotlin.feature_tareas.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebaroomkotlin.feature_tareas.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
}
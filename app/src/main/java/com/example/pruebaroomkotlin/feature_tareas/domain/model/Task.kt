package com.example.pruebaroomkotlin.feature_tareas.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val content: String,
    val timeStamp: Long,
)

class InvalidTaskException(message: String): Exception(message)
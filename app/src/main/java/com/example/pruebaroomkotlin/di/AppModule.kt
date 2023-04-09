package com.example.pruebaroomkotlin.di

import android.app.Application
import androidx.room.Room
import com.example.pruebaroomkotlin.feature_tareas.data.data_source.TaskDatabase
import com.example.pruebaroomkotlin.feature_tareas.domain.repository.TaskRepository
import com.example.pruebaroomkotlin.feature_tareas.domain.repository.TaskRepositoryImpl
import com.example.pruebaroomkotlin.feature_tareas.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTaskDatabase(app: Application): TaskDatabase {
        return Room.databaseBuilder(
            app,
            TaskDatabase::class.java,
            TaskDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db: TaskDatabase): TaskRepository{
        return TaskRepositoryImpl(db.taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(repository: TaskRepository): TaskUseCases{
        return TaskUseCases(
            getTasks = GetTasksUseCase(repository),
            deleteTask = DeleteTaskUseCase(repository),
            createTask = CreateTaskUseCase(repository),
            getTask = GetTaskUseCase(repository),
        )
    }

}
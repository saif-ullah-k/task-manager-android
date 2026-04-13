package com.taskmanager.app.data.repository

import com.taskmanager.app.data.local.TaskDao
import com.taskmanager.app.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()

    fun getTasksByCategory(category: String): Flow<List<Task>> =
        taskDao.getTasksByCategory(category)

    fun getPendingTasks(): Flow<List<Task>> = taskDao.getPendingTasks()

    fun getCompletedTasks(): Flow<List<Task>> = taskDao.getCompletedTasks()

    fun getPendingCount(): Flow<Int> = taskDao.getPendingCount()

    fun getCategories(): Flow<List<String>> = taskDao.getCategories()

    suspend fun getTaskById(id: Int): Task? = taskDao.getTaskById(id)

    suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    suspend fun updateTask(task: Task) = taskDao.updateTask(task)

    suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)

    suspend fun toggleComplete(task: Task) =
        taskDao.updateTask(task.copy(isCompleted = !task.isCompleted))

    suspend fun deleteCompletedTasks() = taskDao.deleteCompletedTasks()
}

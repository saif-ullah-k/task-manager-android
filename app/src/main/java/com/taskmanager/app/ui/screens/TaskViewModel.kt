package com.taskmanager.app.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.taskmanager.app.data.local.TaskDatabase
import com.taskmanager.app.data.model.Priority
import com.taskmanager.app.data.model.Task
import com.taskmanager.app.data.repository.TaskRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class TaskUiState(
    val tasks: List<Task> = emptyList(),
    val pendingCount: Int = 0,
    val categories: List<String> = emptyList(),
    val selectedCategory: String? = null,
    val showCompleted: Boolean = false
)

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository

    private val _uiState = MutableStateFlow(TaskUiState())
    val uiState: StateFlow<TaskUiState> = _uiState.asStateFlow()

    init {
        val dao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(dao)

        viewModelScope.launch {
            repository.getAllTasks().collect { tasks ->
                _uiState.update { it.copy(tasks = tasks) }
            }
        }

        viewModelScope.launch {
            repository.getPendingCount().collect { count ->
                _uiState.update { it.copy(pendingCount = count) }
            }
        }

        viewModelScope.launch {
            repository.getCategories().collect { categories ->
                _uiState.update { it.copy(categories = categories) }
            }
        }
    }

    fun addTask(title: String, description: String, priority: Priority, category: String) {
        viewModelScope.launch {
            repository.insertTask(
                Task(
                    title = title,
                    description = description,
                    priority = priority,
                    category = category
                )
            )
        }
    }

    fun toggleComplete(task: Task) {
        viewModelScope.launch {
            repository.toggleComplete(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun deleteCompletedTasks() {
        viewModelScope.launch {
            repository.deleteCompletedTasks()
        }
    }

    fun filterByCategory(category: String?) {
        viewModelScope.launch {
            if (category == null) {
                repository.getAllTasks().collect { tasks ->
                    _uiState.update { it.copy(tasks = tasks, selectedCategory = null) }
                }
            } else {
                repository.getTasksByCategory(category).collect { tasks ->
                    _uiState.update { it.copy(tasks = tasks, selectedCategory = category) }
                }
            }
        }
    }
}

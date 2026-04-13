package com.taskmanager.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.MEDIUM,
    val category: String = "General",
    val dueDate: Long? = null,
    val createdAt: Long = System.currentTimeMillis()
)

enum class Priority {
    LOW, MEDIUM, HIGH
}

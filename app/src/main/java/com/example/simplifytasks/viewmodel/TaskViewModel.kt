package com.example.simplifytasks.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.simplifytasks.model.Task

class TaskViewModel : ViewModel() {
    private var nextId = 0
    var taskList = mutableStateListOf<Task>()
        private set

    fun addTask(title: String) {
        if (title.isNotBlank()) {
            taskList.add(Task(id = nextId++, title = title))
        }
    }

    fun toggleTaskDone(task: Task) {
        val index = taskList.indexOf(task)
        if (index != -1) {
            taskList[index] = task.copy(isDone = !task.isDone)
        }
    }

    fun removeTask(task: Task) {
        taskList.remove(task)
    }
}



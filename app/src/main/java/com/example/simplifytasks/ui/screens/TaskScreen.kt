package com.example.simplifytasks.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.simplifytasks.model.Task
import com.example.simplifytasks.viewmodel.TaskViewModel



// Enables me to be able to create and type in new tasks, click away from the input box, and upon completing or closing a task
// There are several options to close, delete, or end a task.
// It is pertinent to state that you would not want to use this as a task manager for an ongoing task list.
// This is for simplified tasks, at least for the time being, in-app only.

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    var newTask by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Task Manager", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("New Task") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                if (newTask.isNotBlank()) {
                    viewModel.addTask(newTask)
                    newTask = ""
                }
            }),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        for (task in viewModel.taskList) {
            TaskItem(task, viewModel)
        }
    }
}

// This centers, aligns, and enables my textbox to appear at the top, using the UI suggestions/parameters as currently instated.
// Simplistic to the core, and resembles text boxes from like Android 7, however, for the time being it works!

@Composable
fun TaskItem(task: Task, viewModel: TaskViewModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { viewModel.toggleTaskDone(task) }
            )
            Text(
                task.title,
                style = if (task.isDone)
                    MaterialTheme.typography.bodyMedium.copy(textDecoration = TextDecoration.LineThrough)
                else
                    MaterialTheme.typography.bodyMedium
            )
        }
        IconButton(onClick = { viewModel.removeTask(task) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Task")
        }
    }
}
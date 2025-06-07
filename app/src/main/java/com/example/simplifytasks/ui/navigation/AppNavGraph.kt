package com.example.simplifytasks.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.simplifytasks.ui.screens.TaskScreen
import com.example.simplifytasks.ui.timer.TimerScreen
import com.example.simplifytasks.viewmodel.TaskViewModel
import com.example.simplifytasks.ui.screens.PomodoroEffectScreen


// this enables my hamburger menu icon to appear to allow for swiping and navigation between several windows within the app.
// have only enabled the task list, and pomodoro timer to be enabled on this UI.

@Composable
fun AppNavGraph(navController: NavHostController, taskViewModel: TaskViewModel) {
    NavHost(navController = navController, startDestination = "tasks") {
        composable("tasks") {
            TaskScreen(taskViewModel)
        }
        composable("timer") {
            TimerScreen()
        }
        composable("pomodoro effect") {
            PomodoroEffectScreen()
        }
    }
}

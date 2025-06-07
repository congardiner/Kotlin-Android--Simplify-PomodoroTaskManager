package com.example.simplifytasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.simplifytasks.ui.navigation.AppNavGraph
import com.example.simplifytasks.ui.theme.SimplifyTasksTheme
import com.example.simplifytasks.viewmodel.TaskViewModel
import androidx.compose.material.icons.filled.Info


import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding



import kotlinx.coroutines.launch


// Edit Note: the file structure still probably needs some work, as my gradle 2.0 import was causing major issues for the app as it wasn't configured out of the box by Android Studio.
// Loads of time spent in debugging, sifting through user docs, and finally getting the IDE properly configured.

// There are a few experimental features being used that are related to the material 3 library, which is why this authorization had to be granted
// This was something that I found within the documentation, which was heavily dependent on being able to use some of the new features for menu navigation and other like minded UI elements within this test demo.

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = TaskViewModel()

        setContent {
            SimplifyTasksTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerContent = {
                        ModalDrawerSheet {
                            Text("Menu", style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(16.dp))
                            NavigationDrawerItem(
                                label = { Text("Task List") },
                                icon = { Icon(Icons.Default.List, contentDescription = null) },
                                selected = false,
                                onClick = {
                                    navController.navigate("tasks")
                                    scope.launch { drawerState.close() }
                                }
                            )
                            NavigationDrawerItem(
                                label = { Text("Pomodoro Timer") },
                                icon = { Icon(Icons.Default.Timer, contentDescription = null) },
                                selected = false,
                                onClick = {
                                    navController.navigate("timer")
                                    scope.launch { drawerState.close() }
                                }

                            )

                            NavigationDrawerItem(
                                label = { Text("Pomodoro Effect") },
                                icon = { Icon(Icons.Default.Info, contentDescription = null) },
                                selected = false,
                                onClick = {
                                    navController.navigate("pomodoro_effect")
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("Simplify Tasks") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch { drawerState.open() }
                                    }) {
                                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                                    }
                                }
                            )
                        }
                    ) {
                        // Edit Note: this is a new expermental asset that I've been testing, within my model it doesn't want to work despite many atempts to enable it within the menu nav.
                        AppNavGraph(navController = navController, taskViewModel = viewModel)
                    }
                }
            }
        }
    }
}


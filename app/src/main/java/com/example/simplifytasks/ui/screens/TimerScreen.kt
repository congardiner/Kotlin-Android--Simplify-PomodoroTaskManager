package com.example.simplifytasks.ui.timer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

// These imports mostly from the androidx library were instrumental in enabling any of these functions to work seamlessly once my gradle script is initiated to compile.

// Timer transposed for initiating and allowing the pomodoro timer to actively be set.
// This also makes it so that the user would ideally become more accustomed to using the app, rather than an inbuilt timer, at least at first.


@Composable
fun TimerScreen() {
    var timeLeft by remember { mutableStateOf(25 * 60) } // 25 minutes
    var isRunning by remember { mutableStateOf(false) }

    LaunchedEffect(isRunning) {
        while (isRunning && timeLeft > 0) {
            delay(1000)
            timeLeft -= 1
        }
    }

    // Can store correct values, however, I haven't set locked parameter values for the clock itself,
    // as pomodoro sessions are going to vary user to user and are not something that needs to be dwelled on.

    val minutes = timeLeft / 60
    val seconds = timeLeft % 60

    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    // Ensures that as a formatted string that the timer works as intended with the accepted values (ie, time being within minutes and seconds)
    // has a placeholder for when it has started, paused, and when it needs to be reset within the timer.

    {
        Text(String.format("%02d:%02d", minutes, seconds), style = MaterialTheme.typography.displayMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { isRunning = true }) {
                Text("Start")
            }
            Button(onClick = { isRunning = false }) {
                Text("Pause")
            }
            Button(onClick = {
                isRunning = false
                timeLeft = 25 * 60
            }) {
                Text("Reset")
            }
        }
    }
}

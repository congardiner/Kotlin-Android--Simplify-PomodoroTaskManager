package com.example.simplifytasks.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// I wanted to develop a super simplistic, blue with subtle surface artefact colors for contrast within this app demo.
// blue resonates with the nature and purpose of this task manager app, while there are certainly areas that could be improved,
// the color(s) and overall UI would be one of the primary motivating tasks that would need to be backlogged to my deficiencies to ensure that this works properly.

private val LightColors = lightColorScheme(
    primary = Color(0xFF0C75BB),
    secondary = Color(0xFFBAA9FF),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun SimplifyTasksTheme(
    darkTheme: Boolean = false, // could be dynamic
    content: @Composable () -> Unit
)

// This is a material theme 3 enabled by the latest version of Android Studio, with the purpose being to add more value to the design philosophy that Google is directing with Android 16 pending in the future
// Theoretically this should bring to life the 'physics' and overall transposition of Android, especially from the dev sense within this large space.

{
    MaterialTheme(
        colorScheme = LightColors,
        typography = androidx.compose.material3.Typography(),
        content = content
    )


}

package com.example.simplifytasks.model

// Basic Base Template package installed based off of Android Studio Recommendations.


data class Task(
    val id: Int,
    val title: String,
    var isDone: Boolean = false
)

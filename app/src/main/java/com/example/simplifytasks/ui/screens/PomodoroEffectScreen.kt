package com.example.simplifytasks.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column

// all of the necessary imported packages were used in other pages
// I used this screen to showcase the vital outcomes of the pomodoro effect, why its pertinent and special within studying
// and how it can be used to improve retention within academic settings and professional workspaces.



@Composable
fun PomodoroEffectScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Screen Title
        // Correctly entitled the 'Pomodoro Effect'
        // My journey with it started about 7 years ago.
        Text(
            text = "The Pomodoro Effect",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Under-glow subtitle, hint: the truth hurts...
        Text(
            text = "'Work Smarter, not Harder' ~ Anonymous",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Benefits Cards
        BenefitCard(
            title = "Enhanced Focus",
            description = "Work in focused 25-minute intervals to maintain deep concentration and avoid distractions. This helps your brain stay engaged with the material."
        )

        Spacer(modifier = Modifier.height(16.dp))

        BenefitCard(
            title = "Prevents Burnout",
            description = "Regular 5-minute breaks prevent mental fatigue and help maintain energy levels throughout long study sessions."
        )

        Spacer(modifier = Modifier.height(16.dp))

        BenefitCard(
            title = "Improves Time Management",
            description = "Breaking work into manageable chunks helps you better estimate how long tasks take and plan your study schedule effectively."
        )

        Spacer(modifier = Modifier.height(16.dp))

        BenefitCard(
            title = "Reduces Procrastination",
            description = "The 25-minute commitment feels manageable, making it easier to start tasks you've been avoiding."
        )

        Spacer(modifier = Modifier.height(16.dp))

        BenefitCard(
            title = "Better Retention",
            description = "Spaced learning with breaks allows your brain to process and consolidate information more effectively."
        )

        Spacer(modifier = Modifier.height(32.dp))

        // How it works section
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "How It Works",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Text(
                    text = "1. Choose a task to work on\n" +
                            "2. Set timer for 25 minutes\n" +
                            "3. Work with full focus until timer rings\n" +
                            "4. Take a 5-minute break\n" +
                            "5. After 4 cycles, take a longer 15-30 minute break",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.5f
                )
            }
        }
    }
}


@Composable
fun BenefitCard(
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
               color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.4f
           )
        }
    }
}
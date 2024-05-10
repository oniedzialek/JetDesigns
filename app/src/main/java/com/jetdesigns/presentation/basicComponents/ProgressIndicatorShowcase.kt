package com.jetdesigns.presentation.basicComponents
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicatorShowcase() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var progress by remember { mutableStateOf(0.1f) }

            // Determinate Linear Progress Indicator
            Text("Determinate Linear Progress Indicator", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(20.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Indeterminate Linear Progress Indicator
            Text("Indeterminate Linear Progress Indicator", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(20.dp))
            LinearProgressIndicator()

            Spacer(modifier = Modifier.height(40.dp))

            // Determinate Circular Progress Indicator
            Text("Determinate Circular Progress Indicator", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(
                progress = { progress },
                color = MaterialTheme.colorScheme.secondary,
                strokeWidth = 8.dp,
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Indeterminate Circular Progress Indicator
            Text("Indeterminate Circular Progress Indicator", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator()

            // Update progress for demonstration
            LaunchedEffect(Unit) {
                while (progress < 1f) {
                    progress += 0.01f
                    kotlinx.coroutines.delay(100L)
                    if (progress >= 1f) progress = 0f
                }
            }
        }
    }
}

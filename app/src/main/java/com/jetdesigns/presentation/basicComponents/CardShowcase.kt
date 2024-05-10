package com.jetdesigns.presentation.basicComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardShowcase() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text("Card Showcase", fontSize = 24.sp, color = Color.Black)

            // Basic card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Text(
                    "Basic Card",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp
                )
            }

            // Elevated card
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Text(
                    "Elevated Card",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp
                )
            }

            // Card with rounded corners and custom content
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Card with Rounded Corners", fontSize = 18.sp)
                    Button(
                        onClick = { /* Handle click */ },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Click Me")
                    }
                }
            }
        }
    }
}

package com.jetdesigns.presentation.basicComponents


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonShowcase() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Simple button
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Simple Button")
            }

            // Elevated button
            ElevatedButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Elevated Button")
            }

            // Button with icon
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                Text("Button with Icon", modifier = Modifier.padding(start = 8.dp))
            }

            // Outlined button
            OutlinedButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Outlined Button")
            }

            // Text button
            TextButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Text Button")
            }

            // Button with custom colors
            Button(
                onClick = { /* Handle click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Custom Colors")
            }

            // Button with custom size
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Custom Size", fontSize = 20.sp)
            }
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FloatingActionButton(
                    onClick = { /* Handle FAB click */ },
                    containerColor = MaterialTheme.colorScheme.secondary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
                }
            }

        }
    }
}
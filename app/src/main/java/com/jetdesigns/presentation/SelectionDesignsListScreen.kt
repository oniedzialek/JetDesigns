package com.jetdesigns.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SelectionDesignsListScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonModifier = Modifier
            .padding(10.dp)
            .fillMaxWidth() // Wszystkie przyciski będą miały tę samą szerokość

        // Definicje kolorów
        val purple1 = Color(0xFFE1BEE7)  // Bazowy kolor, jasny fiolet
        val purple2 = Color(0xFFCE93D8)  // Nieco ciemniejszy
        val purple3 = Color(0xFFBA68C8)  // Jeszcze ciemniejszy
        val purple4 = Color(0xFFAB47BC)  // Głęboki fiolet
        val purple5 = Color(0xFF9C27B0)  // Bardziej intensywny fiolet
        val purple6 = Color(0xFF8E24AA)  // Najciemniejszy z proponowanych fioletów

        val textColor = Color(0xFF363636)

        Button(
            onClick = { navController.navigate("loginDesign") },
            colors = ButtonDefaults.buttonColors(containerColor = purple1),
            modifier = buttonModifier
        ) {
            Text(text = "Login", color = textColor)
        }
        Button(
            onClick = { navController.navigate("userProfileDesign") },
            colors = ButtonDefaults.buttonColors(containerColor = purple2),
            modifier = buttonModifier
        ) {
            Text(text = "User Profile", color = textColor)
        }
        Button(
            onClick = { navController.navigate("chatDesign") },
            colors = ButtonDefaults.buttonColors(containerColor = purple3),
            modifier = buttonModifier
        ) {
            Text(text = "Chat", color = textColor)
        }
        Button(
            onClick = { navController.navigate("settingsDesign") },
            colors = ButtonDefaults.buttonColors(containerColor = purple4),
            modifier = buttonModifier
        ) {
            Text(text = "Settings", color = textColor)
        }

    }
}

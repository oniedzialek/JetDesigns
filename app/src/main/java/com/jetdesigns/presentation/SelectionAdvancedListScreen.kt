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
fun SelectionAdvancedListScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonModifier = Modifier
            .padding(10.dp)
            .fillMaxWidth() // Wszystkie przyciski będą miały tę samą szerokość

        // Definicje kolorów
        val yellow1 = Color(0xFFFFCD30)  // Bazowy kolor, jasny żółty
        val yellow2 = Color(0xFFFFC400)  // Nieco ciemniejszy
        val yellow3 = Color(0xFFFFBB00)  // Jeszcze ciemniejszy
        val yellow4 = Color(0xFFFFB200)  // Głęboki żółty
        val yellow5 = Color(0xFFFFA800)  // Bardziej intensywny żółty
        val yellow6 = Color(0xFFFF9E00)  // Najciemniejszy z proponowanych żółtych

        val textColor = Color(0xFF363636)

        Button(
            onClick = { navController.navigate("lazyShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow1),
            modifier = buttonModifier
        ) {
            Text(text = "Lazy Columns and Rows", color = textColor)
        }

        Button(
            onClick = { navController.navigate("gridsShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow2),
            modifier = buttonModifier
        ) {
            Text(text = "Grid layout", color = textColor)
        }

        Button(
            onClick = { navController.navigate("expandableLayoutShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow3),
            modifier = buttonModifier
        ) {
            Text(text = "Expandable layout", color = textColor)
        }
        Button(
            onClick = { navController.navigate("bottomSheetShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow4),
            modifier = buttonModifier
        ) {
            Text(text = "Bottom Sheet", color = textColor)
        }
        Button(
            onClick = { navController.navigate("tabShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow5),
            modifier = buttonModifier
        ) {
            Text(text = "Tab", color = textColor)
        }
        Button(
            onClick = { navController.navigate("pagingShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow6),
            modifier = buttonModifier
        ) {
            Text(text = "Paging", color = textColor)
        }
        Button(
            onClick = { navController.navigate("dialogsShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow6),
            modifier = buttonModifier
        ) {
            Text(text = "Dialogs", color = textColor)
        }
        Button(
            onClick = { navController.navigate("gesturesShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = yellow6),
            modifier = buttonModifier
        ) {
            Text(text = "Gestures", color = textColor)
        }





    }

}
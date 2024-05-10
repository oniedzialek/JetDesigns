package com.jetdesigns.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jetdesigns.presentation.basicComponents.TextSchowcase

@Composable
fun SelectionBasicListScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonModifier = Modifier
            .padding(10.dp)
            .fillMaxWidth() // Wszystkie przyciski będą miały tę samą szerokość

        // Definicje kolorów
        val mintGreen1 = Color(0xFFa2e8af) // Jaśniejszy, ale nie blady
        val mintGreen2 = Color(0xFF8EE4AF) // Ciemniejszy odcień limonkowo-miętowy
        val mintGreen3 = Color(0xFF70DB93) // Kolejny stopień intensywności
        val mintGreen4 = Color(0xFF5CD672) // Jeszcze ciemniejszy
        val mintGreen5 = Color(0xFF3EDC81) // Bardzo żywy i głęboki odcień
        val mintGreen6 = Color(0xFF20C773) // Najciemniejszy z proponowanych odcieni

        val textColor = Color(0xFF363636)

        Button(
            onClick = { navController.navigate("textShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen1),
            modifier = buttonModifier
        ) {
            Text(text = "Text", color = textColor)
        }

        Button(
            onClick = { navController.navigate("buttonShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen2),
            modifier = buttonModifier
        ) {
            Text(text = "Button", color = textColor)
        }

        Button(
            onClick = { navController.navigate("textFieldShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen3),
            modifier = buttonModifier
        ) {
            Text(text = "TextField", color = textColor)
        }

        Button(
            onClick = { navController.navigate("checkboxShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen4),
            modifier = buttonModifier
        ) {
            Text(text = "Checkbox & Radio button", color = textColor)
        }

        Button(
            onClick = { navController.navigate("switchAndSliderShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen5),
            modifier = buttonModifier
        ) {
            Text(text = "Switch & Sider", color = textColor)
        }

        Button(
            onClick = { navController.navigate("progressIndicatorShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen6),
            modifier = buttonModifier
        ) {
            Text(text = "Progress Indicator", color = textColor)
        }
        Button(
            onClick = { navController.navigate("iconsShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen6),
            modifier = buttonModifier
        ) {
            Text(text = "Icons", color = textColor)
        }
        Button(
            onClick = { navController.navigate("cardShowcase") },
            colors = ButtonDefaults.buttonColors(containerColor = mintGreen6),
            modifier = buttonModifier
        ) {
            Text(text = "Card", color = textColor)
        }
    }
}
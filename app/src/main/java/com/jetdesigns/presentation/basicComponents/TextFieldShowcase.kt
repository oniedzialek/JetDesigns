package com.jetdesigns.presentation.basicComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldShowcase() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Standard TextField
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Standard TextField") },
                singleLine = true,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Password TextField
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password TextField") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Number Input TextField
            TextField(
                value = number,
                onValueChange = { number = it },
                label = { Text("Number TextField") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Text Field with Placeholder and Helper Text
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your name") }, // Etykieta, która pojawi się w polu tekstowym
                placeholder = { Text("Placeholder text") }, // Tekst zastępczy pokazujący się, gdy pole jest puste
                singleLine = true, // Określa, czy pole tekstowe ma być jednoliniowe
                visualTransformation = VisualTransformation.None, // Możliwość transformacji wprowadzanego tekstu, np. do formatu hasła
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done) // Opcje klawiatury, np. akcja "Done" na klawiaturze
            )

            // Text Field with Leading and Trailing Icons
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("TextField with Icons") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite") },
                trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Info") },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("TextField with Icons") },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { /* Obsługa kliknięcia na ikonę Favorite */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favorite",
                            tint = Color.Red // Opcjonalnie możesz dodać kolor
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { /* Obsługa kliknięcia na ikonę Info */ }) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                            tint = Color.Blue // Opcjonalnie możesz dodać kolor
                        )
                    }
                },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Text Field with Error State
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Error TextField") },
                isError = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
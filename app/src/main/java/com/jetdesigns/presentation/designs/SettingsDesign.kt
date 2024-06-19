package com.jetdesigns.presentation.designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jetdesigns.R

@Composable
fun SettingsDesign() {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }
    var marketingConsent by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Settings", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))
        LazyColumn {
            item {
                SettingSwitch("Enable Notifications", notificationsEnabled) { newValue ->
                    notificationsEnabled = newValue
                }
            }
            item {
                SettingSwitch("Dark Mode", darkModeEnabled) { newValue ->
                    darkModeEnabled = newValue
                }
            }
            item {
                SettingCheckbox("Marketing Consent", marketingConsent) { newValue ->
                    marketingConsent = newValue
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Settings Saved") },
            text = {
                Column {
                    Text("Notifications Enabled: $notificationsEnabled")
                    Text("Dark Mode Enabled: $darkModeEnabled")
                    Text("Marketing Consent: $marketingConsent")
                }
            },
            confirmButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun SettingSwitch(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingCheckbox(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }

    Box {
        Text("Text on top")
        Image(painter = painterResource(R.drawable.ice), contentDescription = null)
    }
    Text("Hello, Compose!")
    Button(onClick = { /* Do something */ }) {
        Text("Click Me")
    }

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text("Enter text") }
    )
    LazyColumn {
        items(listOf("Item 1", "Item 2", "Item 3")) { item ->
            Text(item)
        }
    }
    Text("Hello, Modifier!", modifier = Modifier.padding(16.dp))

    Card(elevation = CardDefaults.cardElevation(4.dp)) {
        Text("This is a card")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}



package com.jetdesigns.presentation.designs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun ChatDesign() {
    var messageText by remember { mutableStateOf(TextFieldValue()) }
    val messages = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.fillMaxSize()) {
        MessagesList(messages)
        UserInput(messageText) { updatedText ->
            messageText = updatedText
        }
        SendButton {
            if (messageText.text.isNotBlank()) {
                messages.add(messageText.text)
                messageText = TextFieldValue()  // Clear the input field after sending
            }
        }
    }
}

@Composable
fun MessagesList(messages: List<String>) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
    ) {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Composable
fun MessageCard(message: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInput(text: TextFieldValue, onTextChange: (TextFieldValue) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text("Type a message...") },
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
    )
}

@Composable
fun SendButton(onSend: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = onSend) {
            Icon(Icons.Filled.Send, contentDescription = "Send")
            Text("Send")
        }
    }
}

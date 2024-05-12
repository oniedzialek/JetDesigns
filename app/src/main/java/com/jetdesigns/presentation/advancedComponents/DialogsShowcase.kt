package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun DialogsShowcase() {
    var showDialog by remember { mutableStateOf(false) }
    var showListDialog by remember { mutableStateOf(false) }
    var showConfirmationDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column {
                Button(onClick = { showDialog = true }) {
                    Text("Show Basic Dialog")
                }
                Button(onClick = { showListDialog = true }) {
                    Text("Show List Dialog")
                }
                Button(onClick = { showConfirmationDialog = true }) {
                    Text("Show Confirmation Dialog")
                }
                Button(onClick = { showCustomDialog = true }) {
                    Text("Show Custom Dialog")
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Basic Dialog") },
                        text = { Text("This is a basic dialog example.") },
                        confirmButton = {
                            Button(onClick = { showDialog = false }) {
                                Text("OK")
                            }
                        }
                    )
                }

                if (showListDialog) {
                    AlertDialog(
                        onDismissRequest = { showListDialog = false },
                        title = { Text("List Dialog") },
                        text = {
                            Column {
                                Text("Option 1")
                                Text("Option 2")
                                Text("Option 3")
                            }
                        },
                        confirmButton = {
                            Button(onClick = { showListDialog = false }) {
                                Text("Close")
                            }
                        }
                    )
                }

                if (showConfirmationDialog) {
                    AlertDialog(
                        onDismissRequest = { showConfirmationDialog = false },
                        title = { Text("Confirmation") },
                        text = { Text("Do you want to proceed?") },
                        confirmButton = {
                            Button(onClick = {
                                showConfirmationDialog = false
                                // Handle confirmation action
                            }) {
                                Text("Yes")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { showConfirmationDialog = false }) {
                                Text("No")
                            }
                        }
                    )
                }

                if (showCustomDialog) {
                    Dialog(onDismissRequest = { showCustomDialog = false }) {
                        // Custom design for dialog content
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            tonalElevation = 8.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    "Custom Dialog",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Spacer(Modifier.height(20.dp))
                                Text("You can place any content you want here.")
                                Button(onClick = { showCustomDialog = false }) {
                                    Text("Close")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

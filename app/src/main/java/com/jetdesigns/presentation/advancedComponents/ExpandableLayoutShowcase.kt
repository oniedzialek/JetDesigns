package com.jetdesigns.presentation.advancedComponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableLayoutShowcase() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(

            ) {
                Column(
                    modifier = Modifier
                        .padding(25.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var expanded by remember { mutableStateOf(false) }

                    // Header that you can click to expand or collapse the content
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expanded = !expanded }
                            .padding(12.dp)
                    ) {
                        Text(
                            text = if (expanded) "Click to collapse" else "Click to expand",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = if (expanded) "Collapse" else "Expand",
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    // Content that can be expanded or collapsed
                    AnimatedVisibility(visible = expanded) {
                        Column(
                            modifier = Modifier.padding(
                                start = 16.dp,
                                end = 16.dp,
                                top = 8.dp,
                                bottom = 8.dp
                            )
                        ) {
                            Text("Detail 1", style = MaterialTheme.typography.bodyLarge)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text("Detail 2", style = MaterialTheme.typography.bodyLarge)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text("Detail 3", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }


            Box(

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    var expanded by remember { mutableStateOf(false) }
                    Button(onClick = { expanded = true }) {
                        Text("Open Menu")
                    }

                    // DropdownMenu to display the options
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.width(200.dp) // You can set the width as per your design needs
                    ) {
                        DropdownMenuItem(
                            text = { Text("Option 1") },
                            onClick = {
                                expanded = false
                                // Handle "Option 1" action
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Option 2") },
                            onClick = {
                                expanded = false
                                // Handle "Option 2" action
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Option 3") },
                            onClick = {
                                expanded = false
                                // Handle "Option 3" action
                            }
                        )
                    }
                }
            }

        }
    }}
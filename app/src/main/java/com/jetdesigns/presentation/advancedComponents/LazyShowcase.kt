package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyShowcase() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column(modifier = Modifier
            .fillMaxHeight(0.7f)
            .align(Alignment.TopCenter).padding(bottom = 16.dp)) {
            Text("Vertical Lazy List", style = MaterialTheme.typography.headlineSmall)
            LazyColumnExample()
        }

        Column(modifier = Modifier
            .fillMaxHeight(0.3f)
            .align(Alignment.BottomCenter).padding(top = 16.dp)) {
            Text("Horizontal Lazy List", style = MaterialTheme.typography.headlineSmall)
            LazyRowExample()
        }

    }
}

@Composable
fun LazyColumnExample(modifier: Modifier = Modifier) {
    // Przykładowe dane
    val itemsList = List(100) { "Item #$it" }
    LazyColumn {
        items(itemsList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun LazyRowExample(modifier: Modifier = Modifier) {
    // Przykładowe dane
    val itemsList = List(20) { "Element #$it" }
    LazyRow {
        items(itemsList) { item ->
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .padding(4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

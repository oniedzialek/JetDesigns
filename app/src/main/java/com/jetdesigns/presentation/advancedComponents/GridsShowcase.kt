package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GridsShowcase() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lazy Vertical Grid", style = MaterialTheme.typography.titleMedium)
        LazyVerticalGridExample()
        Spacer(modifier = Modifier.height(30.dp))
        Text("Simulated Lazy Horizontal Grid", style = MaterialTheme.typography.titleMedium)
        SimulatedLazyHorizontalGridExample()
    }
}

@Composable
fun LazyVerticalGridExample() {
    // Sample data
    val itemsList = List(30) { "Item #$it" }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Setting the grid to have fixed three columns
        modifier = Modifier.height(300.dp) // Set a fixed height to see the scroll effect
    ) {
        items(itemsList) { item ->
            Card(
                modifier = Modifier.padding(4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
@Composable
fun SimulatedLazyHorizontalGridExample() {
    // Przykładowe dane, gdzie każdy element to para ciągów
    val itemsList = List(50) { "Element #${it*2}, Element #${it*2+1}" }

    LazyRow(modifier = Modifier.height(300.dp)) {  // Ustawienie stałej wysokości dla LazyRow
        items(itemsList) { item ->
            // Rozdzielanie ciągów dla pary elementów
            val pair = item.split(", ")
            Column(modifier = Modifier.width(200.dp).padding(4.dp)) {
                // Tworzenie karty dla każdego elementu w kolumnie
                pair.forEach { element ->
                    Card(
                        modifier = Modifier.padding(4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Text(text = element, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}
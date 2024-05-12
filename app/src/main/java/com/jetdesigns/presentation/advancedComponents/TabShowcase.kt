package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TabShowcase() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.Center)
        ) {
            SimpleTabsComponent()
            Spacer(modifier = Modifier.height(20.dp))
            ScrollableTabsComponent()
        }
    }
}

@Composable
fun SimpleTabsComponent() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Home", "Profile", "Settings")

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            divider = {}
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }
        TabContent("Selected tab: ${tabTitles[selectedTabIndex]}")
    }
}

@Composable
fun ScrollableTabsComponent() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = List(10) { "Item ${it + 1}" }

    Column {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 16.dp
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }
        TabContent("Content for ${tabTitles[selectedTabIndex]}")
    }
}

@Composable
fun TabContent(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center
    )
}

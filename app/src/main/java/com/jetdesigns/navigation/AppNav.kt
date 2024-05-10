package com.jetdesigns.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetdesigns.presentation.SelectionAdvancedListScreen
import com.jetdesigns.presentation.SelectionBasicListScreen
import com.jetdesigns.presentation.SelectionDesignsListScreen
import com.jetdesigns.presentation.basicComponents.ButtonShowcase
import com.jetdesigns.presentation.basicComponents.CardShowcase
import com.jetdesigns.presentation.basicComponents.CheckboxShowcase
import com.jetdesigns.presentation.basicComponents.IconsShowcase
import com.jetdesigns.presentation.basicComponents.ProgressIndicatorShowcase
import com.jetdesigns.presentation.basicComponents.SwitchAndSliderShowcase
import com.jetdesigns.presentation.basicComponents.TextFieldShowcase
import com.jetdesigns.presentation.basicComponents.TextSchowcase
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetdesigns.presentation.advancedComponents.GridsShowcase
import com.jetdesigns.presentation.advancedComponents.LazyShowcase


@Composable
fun AppNav() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Basic") },
                    label = { Text("Basic") },
                    selected = navController.currentDestination?.route == "mainScreen",
                    onClick = { navController.navigate("mainScreen") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "Advanced") },
                    label = { Text("Advanced") },
                    selected = navController.currentDestination?.route == "advancedScreen",
                    onClick = { navController.navigate("advancedScreen") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = "Designs") },
                    label = { Text("Designs") },
                    selected = navController.currentDestination?.route == "designsScreen",
                    onClick = { navController.navigate("designsScreen") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = "mainScreen", modifier = Modifier.padding(paddingValues)) {
            composable("mainScreen") { SelectionBasicListScreen(navController) }
            composable("advancedScreen") { SelectionAdvancedListScreen(navController) }
            composable("designsScreen") { SelectionDesignsListScreen(navController) }

            composable("textShowcase") { TextSchowcase() }
            composable("buttonShowcase") { ButtonShowcase() }
            composable("textFieldShowcase") { TextFieldShowcase() }
            composable("checkboxShowcase") { CheckboxShowcase() }
            composable("switchAndSliderShowcase") { SwitchAndSliderShowcase() }
            composable("progressIndicatorShowcase") { ProgressIndicatorShowcase() }
            composable("iconsShowcase") { IconsShowcase() }
            composable("cardShowcase") { CardShowcase() }

            composable("lazyShowcase") { LazyShowcase() }
            composable("gridsShowcase") { GridsShowcase() }
            // Dodaj pozostałe ścieżki do komponentów, jak wcześniej
        }
    }
}


